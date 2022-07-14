package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.services.CategoriasService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriasServiceImpl;

@WebServlet("/api/AltaDatosController")
public class AltaDatosController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		CategoriasService categoriaService = new CategoriasServiceImpl();
		
		try {
			List<Categorias> categoriaList = categoriaService.findAll();
			
			Map<String, Object> json = new HashMap<>();
			json.put("categorias", categoriaList);
			String jsonString = objectMapper.writeValueAsString(json);
			resp.getWriter().print(jsonString);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
