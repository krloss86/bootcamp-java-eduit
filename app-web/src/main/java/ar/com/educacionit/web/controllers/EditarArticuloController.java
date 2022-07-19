package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

@WebServlet("/controllers/EditarArticuloController")
public class EditarArticuloController extends BaseServlet {

	private static final long serialVersionUID = -2276928232071071563L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");//aca viene el valor del hidden
		
		//validar
		if(id != null) {
			ArticulosService service = new ArticulosServiceImpl();
			
			try {
				Articulo articulo = service.getById(Long.parseLong(id));
			
				ObjectMapper objectMapper = new ObjectMapper();			
				String jsonString = objectMapper.writeValueAsString(articulo);
				resp.getWriter().print(jsonString);
			} catch (Exception e) {
				e.printStackTrace();				
			}
		}
	}
}
