package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.services.parser.CSVFileParser;
import ar.com.educacionit.services.parser.IParser;
import ar.com.educacionit.services.parser.ArticuloDTO;
import ar.com.educacionit.web.enums.AttributesEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

@WebServlet("/controllers/UploadController")
@MultipartConfig
public class UploadController extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// capturar el "file" > Part
		Part filePart = req.getPart("file");
		
		ViewsEnum target = ViewsEnum.UPLOAD_PREVIEW;
		
		if(filePart == null || filePart.getSize() == 0) {
			super.setAttribute(AttributesEnum.ERROR_GENERAL, req, "Debe seleccionar un Archivo");
			target = ViewsEnum.UPLOAD;
			redirect(target, req, resp);
		}
		
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		
		String ext = this.getExt(fileName);

		IParser<Collection<ArticuloDTO>> fileParser = null;;  
		switch (ext) {
			case "csv":{
				fileParser = new CSVFileParser(filePart);
			}
		}
		
		if(fileParser == null) {
			super.setAttribute(AttributesEnum.ERROR_GENERAL, req, "Ext de archivo incorrecto");
			target = ViewsEnum.UPLOAD;
			redirect(target, req, resp);
		}
		
		try {
			Collection<ArticuloDTO> articulos = fileParser.parse();
			super.setAttribute(AttributesEnum.UPLOAD_PREVIEW_KEY, req.getSession(), articulos);
		}catch (Exception e) {
			super.setAttribute(AttributesEnum.ERROR_GENERAL, req.getSession(),"No se ha podido parear el archivo: " + fileName);
			target = ViewsEnum.UPLOAD;
		}
		 
		redirect(target, req, resp);
	}

	private String getExt(String fileName) {
		//nombre
		//ext
		String[] names = fileName.split("\\.");
		return names[names.length-1];
	}
}
