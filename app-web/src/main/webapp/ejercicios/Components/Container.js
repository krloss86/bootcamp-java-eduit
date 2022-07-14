/*funciones */
function getTareas() {
	let tareas = localStorage.getItem('tareas');
	
	if(!tareas) {
		tareas = [];
	}else {
		tareas = JSON.parse(tareas);    			
	}
	
	return tareas;
}

function setTareas(tareas) {
	localStorage.setItem('tareas',JSON.stringify(tareas));
}

function Container() {
	return `<div class="container">
	   		<div class="row">
		    	<div class="col">
			    	<label>Tarea:</label>
			    	<input type="text" id="tarea">
		    		
		    		<button class="btn btn-success" id="btnAgregar" onclick="agregarItem()">
		    			Agregar Tarea
		    		</button>
		    		<button class="btn btn-danger" id="btnAgregar" onclick="eliminarTodos()">
		    			Limpiar
		    		</button>
			    	<div id="tareas">vacio</div>
			    </div>
	    	</div>
    </div>`;
}