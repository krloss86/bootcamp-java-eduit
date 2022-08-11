<!DOCTYPE html>
<%@page import="ar.com.educacionit.services.parser.ArticuloDTO"%>
<%@page import="ar.com.educacionit.web.enums.AttributesEnum"%>
<%@page import="java.util.Collection"%>
<html lang="en">
<head>
    <title>Preview</title>
	<%@include file="/views/header.jsp" %></head>
<body>
	<%@include file="navbar.jsp" %>
    <main>
    	<%@include file="mensajeria.jsp" %>
	    <div class="container">
	        <section>
		    	<div class="row">
		    		<div class="col-12">
				        <h1>
				            Listado
				        </h1>
				        	<%Collection<ArticuloDTO> list = (Collection<ArticuloDTO>)request.getSession().getAttribute(AttributesEnum.UPLOAD_PREVIEW_KEY.getValue());%>
							<table class="table">
							  <thead>
							    <tr>
							      <th scope="col">T&iacute;tulo</th>
							      <th scope="col">C&oacute;digo</th>
							      <th scope="col">Precio</th>
							    </tr>
							  </thead>
							  <tbody>
							  	<% for(ArticuloDTO fila : list) { %>
								    <tr>
								      <td> <%=fila.getTitle() %></td>
								      <td> <%=fila.getCode() %></td>
								      <td> <%=fila.getPrice() %></td>
								    </tr>
							    <%} %>						   
							  </tbody>
							</table>
				     </div>
			    </div>
				<div class="row">
					<div class="col-12">
	    				<a role="button" class="btn btn-success" href="<%=request.getContextPath()%>/controllers/CargarController">
	    					Guardar
	    				</a>
	    			</div>  	
		     	</div>
	     </div>
	    </main>
	</body>
</html>