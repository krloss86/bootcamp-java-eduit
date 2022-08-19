<!DOCTYPE html>
<%@page import="ar.com.educacionit.domain.Articulo"%>
<%@page import="ar.com.educacionit.services.parser.ArticuloDTO"%>
<%@page import="ar.com.educacionit.web.enums.AttributesEnum"%>
<%@page import="java.util.Collection"%>
<html lang="en">
<head>
<title>Preview</title>
<%@include file="/views/header.jsp"%></head>
<body>
	<%@include file="navbar.jsp"%>
	<main>
		<%@include file="mensajeria.jsp"%>
		<div class="container">
			<section>
				<div class="row">
					<div class="col-12">
						<h1>Listado OK</h1>
						<%
						Collection<Articulo> list = (Collection<Articulo>) request.getAttribute(AttributesEnum.ARTICULOS_OKS.getValue());
						%>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">T&iacute;tulo</th>
									<th scope="col">C&oacute;digo</th>
									<th scope="col">Precio</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (Articulo fila : list) {
								%>
								<tr>
									<td><%=fila.getId()%></td>
									<td><%=fila.getTitulo()%></td>
									<td><%=fila.getCodigo()%></td>
									<td><%=fila.getPrecio()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>

				<div class="row">
					<div class="col-12">
						<h1>Listado fail</h1>
						<%
						Collection<ArticuloDTO> listFails = (Collection<ArticuloDTO>) request.getSession().getAttribute(AttributesEnum.ARTICULOS_FAILS.getValue());
						%>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">T&iacute;tulo</th>
									<th scope="col">C&oacute;digo</th>
									<th scope="col">Precio</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (ArticuloDTO fila : listFails) {
								%>
								<tr>
									<td><%=fila.getTitle()%></td>
									<td><%=fila.getCode()%></td>
									<td><%=fila.getPrice()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
					<div class="row">
						<div clas="col-md-12 col-lg-6">
							<%
								if(!listFails.isEmpty()) {
							%>
								<label>Exportar archivo:</label>
								<form action="<%=request.getContextPath()%>/controllers/ExportarController">
									<select class="form-select" 
										aria-label="Fomato de salida"
										name="formato">
											<option value="CSV">CSV</option>
											<option value="XLSX">XLSX</option>
											<option value="PDF">PDF</option>
									</select>
									<button class="btn btn-secondary">
										Exportar
									</button>
								</form>
							<%
								}
							%>
						</div>
					</div>
				</div>
		</div>
	</main>
</body>
</html>