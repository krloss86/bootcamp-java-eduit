<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.AttributesEnum"%>
<%@page import="ar.com.educacionit.domain.Articulo"%>
<%@page import="java.util.Collection"%>
<html lang="en">
<head>
<title>Upload</title>
<%@include file="/views/header.jsp"%></head>
<body>
	<%@include file="navbar.jsp"%>
	<main>
		<%@include file="mensajeria.jsp"%>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1>Upload File</h1>
					<section>
					<form action="<%=request.getContextPath()%>/controllers/UploadController"
						method="post"
						enctype="multipart/form-data"
						>
						<div class="mb-3">
						  <label for="formFile" 
						  	class="form-label">Archivo de productos</label>
						  <input class="form-control" 
						  	type="file" 
						  	id="formFile"
						  	name="file">
						</div>
						
						<button class="btn btn-primary">
							Upload
						</button>
					</form>
					</section>
				</div>
			</div>
		</div>
	</main>
</body>
</html>