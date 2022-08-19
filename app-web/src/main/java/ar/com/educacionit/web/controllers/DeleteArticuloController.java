package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;
import ar.com.educacionit.web.enums.AttributesEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

@WebServlet("/controllers/DeleteArticuloController")
public class DeleteArticuloController extends BaseServlet {

	private static final long serialVersionUID = -2276928232071071563L;

	//public doGet(String[] args) throws ServiceException {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");//aca viene el valor del hidden
		
		ViewsEnum target = ViewsEnum.LISTADO_CONTROLLER;
		
		//validar
		if(id != null) {
			ArticulosService service = new ArticulosServiceImpl();
			
			try {
				service.delete(Long.parseLong(id));
				super.setAttribute(AttributesEnum.EXITO, req, "Se ha eliminado exitosamente el id:" + id);
			} catch (Exception e) {
				e.printStackTrace();
				super.setAttribute(AttributesEnum.ERROR_GENERAL, req, e.getMessage() + "-"+e.getCause().getMessage());
			}
		}
		
		redirect(target, req, resp);
	}
}
