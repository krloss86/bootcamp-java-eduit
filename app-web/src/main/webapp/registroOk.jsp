<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.AttributesEnum"%>
<%@page import="ar.com.educacionit.domain.Articulo"%>
<%@page import="java.util.Collection"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase2 HTML</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <main>
	    <div class="container">
	    	<div class="row">
	    		<div class="col-6">
			        <h1>
			            JSP + Servlet
			        </h1>
			        <section>
			        	<h3>Lista de Articulos = <%Collection<Articulo> list = (Collection<Articulo>)request.getAttribute(AttributesEnum.ARTICULOS.getValue());%> </h3>
						<table class="table">
						  <thead>
						    <tr>
						      <th scope="col">#</th>
						      <th scope="col">T&iacute;tulo</th>
						      <th scope="col">C&oacute;digo</th>
						      <th scope="col">Precio</th>
						      <th scope="col">Acciones</th>
						    </tr>
						  </thead>
						  <tbody>
						  	<% for(Articulo fila : list) { %>
							    <tr>
							      <th scope="row"> <%=fila.getId() %> </th>
							      <td> <%=fila.getTitulo() %></td>
							      <td> <%=fila.getCodigo() %></td>
							      <td> <%=fila.getPrecio() %></td>
							      <td> 
							      		<!-- Button trigger modal
										<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
										  Eliminar
										</button>
										-->
										<a class="btn btn-danger" role="button" href="<%=request.getContextPath()%>/controllers/EliminarArticuloServlet?id=<%=fila.getId() %>">Eliminar</a>
							      		<a class="btn btn-primary" role="button">Editar</a>
							      </td>
							    </tr>
						    <%} %>						   
						  </tbody>
						</table>
			        	<a href="<%=request.getContextPath()%>/">Volver</a>			         	       
			     	</section>
			     </div>
		     </div>
	     </div>
	    </main>
	    <!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        ...
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div>
		  </div>
		</div>
   	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>