<!DOCTYPE html>
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
			        	<!-- objeto implicito -->
			        				  <!--/app-web-->
			         	<form action="<%=request.getContextPath()%>/controller/AltaFormularioServlet" method="POST">
			        		<label for="fecha" class="form-label">Fecha</label>
			        		<input type="date" name="fecha" class="form-control">
			        		<button class="btn btn-info mt-2">
			        			Enviar
			        		</button> 
			        	</form>           
			     	</section>
			     </div>
		     </div>
	     </div>
	    </main>	      
   	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>