package ar.com.educacionit.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.web.enums.AttributesEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

public class BaseServlet extends HttpServlet {

	public void redirect(ViewsEnum view,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(view.getValue()).forward(request, response);
	}
	
	public void setAttribute(AttributesEnum attribute, HttpServletRequest req,Object value) {
		req.setAttribute(attribute.getValue(), value);
	}
	public void setAttribute(AttributesEnum attribute, HttpSession  session,Object value) {
		session.setAttribute(attribute.getValue(), value);
	}
}
