<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase2 HTML</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script>
    	function agregarTarea(){
    		let inputTarea = document.getElementById('tarea');
    		
    		console.log(inputTarea);
    		
    		let valorDelInput = inputTarea.value;
    		console.log(valorDelInput);
    		
    		//JSON
    		let tareas = localStorage.getItem('tareas');
    		
    		if(!tareas) {
    			tareas = [];
    		}else {
				tareas = JSON.parse(tareas);    			
    		}
    		
    		tareas.push(valorDelInput);
    		
    		//antes de guardar
    		localStorage.setItem('tareas', JSON.stringify(tareas));
    		
    		//limpiar el input
    		inputTarea.value = '';
    		inputTarea.focus();
    		
    		//render
    		render();
    	}    
    </script>
</head>
<body onload="render();">
    <main>
	    <div class="container">
	    	<div class="row">
		    	<div class="col">
			    	<label>Tarea:</label>
			    	<input type="text" id="tarea">
		    		
		    		<button id="btnAgregar" onclick="agregarTarea()">
		    			Agregar Tarea
		    		</button>
		    		
			    	<div id="tareas">vacio</div>
			    </div>
	    	</div>
	    </div>
    </main>
</body>
<script>
	/*const divTareas = document.getElementById('tareas');	
	let tareasInLocalStorage = localStorage.getItem('tareas');	
	divTareas.innerHTML = tareasInLocalStorage;
	*/
	function render() {
		const divTareas = document.getElementById('tareas');
		divTareas.innerHTML = 'ya no está vacio';
	
		let tareasInLocalStorage = localStorage.getItem('tareas');
		//let text = '';
		let ul = '<ul>'//document.createElement('ul');
		//let li = document.createElement('li');
	
		if(tareasInLocalStorage !== null) {
			tareasInLocalStorage = JSON.parse(tareasInLocalStorage);
			for (let i = 0; i < tareasInLocalStorage.length; i++) {
				//text += tareasInLocalStorage[i] + "<br>";
				ul+=`<li>${tareasInLocalStorage[i]}`;
			}
		}
		divTareas.innerHTML = ul;
	}
</script>
</html>