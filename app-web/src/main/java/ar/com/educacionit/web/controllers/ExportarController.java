package ar.com.educacionit.web.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.ActionBuilder;
import ar.com.educacionit.web.enums.AttributesEnum;
import ar.com.educacionit.web.enums.FormatoEnum;
import ar.com.educacionit.web.enums.IExportable;

@WebServlet("/controllers/ExportarController")
public class ExportarController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String formato = req.getParameter("formato");
		
		FormatoEnum _enum =  FormatoEnum.getByValue(formato);
		
		IExportable action = ActionBuilder.getAction(_enum);

		Collection<Serializable> fails = (Collection<Serializable>)req.getSession().getAttribute(AttributesEnum.ARTICULOS_FAILS.getValue());
		
		String lines = action.exportar(fails);

		String fileName = "listado-"+new Date().getTime();
		
		String path = File.separator + "desarrollo" + File.separator + fileName + "." + formato;
		
		File file = new File(path);
		
		if(!file.exists()) {
			Files.createFile(file.toPath());
		}
		
		FileWriter fr = new FileWriter(file);
		fr.write(lines);
		
		fr.close();
		
		//descarga del file
		descargar(fileName,formato,file,resp);
		
		//response genere una descarga de archivo
		
	}

	private void descargar(String fileName, String formato, File file, HttpServletResponse resp) throws IOException {
		
		//resp que tipo de archivo debe descargar
		resp.setContentType("text/csv");
		
		String fileNameDownload = fileName + "."+ formato;
		
		resp.setHeader("Content-Disposition", "attachment; filename=\""+fileNameDownload+"\"");
		
		OutputStream os = resp.getOutputStream();
		
		byte[] bytes = Files.readAllBytes(file.toPath());
		
		//elimino el file
		file.delete();
		
		os.write(bytes);
		
		os.flush();
		
		os.close();
	}
}
