function List(items) {
	let List = '<ul>';
	for (let i = 0; i < items.length; i++) {
		List += Item(items[i]);
	}	
	List+='</ul>';
	
	return List;
}

/*funciones*/

function agregarItem(){
	let inputTarea = document.getElementById('tarea');
	
	let valorDelInput = inputTarea.value;
	
	if(!valorDelInput) {
		return;	
	}
	//JSON
	let tareas = getTareas();
	
	//crear un objeto
	const item = {
		id: Math.random(),
		value:valorDelInput
	};
	
	//tareas.push(valorDelInput);
	tareas.push(item);
	
	//antes de guardar
	setTareas(tareas);
	
	//limpiar el input
	inputTarea.value = '';
	inputTarea.focus();
	
	//render
	render();
}   

function eliminarItem(id) {
	if(confirm('¿Confirma?')) {
		//debo recorrer el array de tareas y buscar el id enviado por parametro
		
		let tareas = getTareas();
		let tareasAux = [];
		for(let i=0;i<tareas.length;i++) {
			if(tareas[i].id !== id ) {
				tareasAux.push(tareas[i]);
			}
		}
		
		//update del localStorage
		setTareas(tareasAux);
		
		//render
		render();
	}
}

function eliminarTodos() {
	const confirma = confirm('Confirma?');
	if(confirma) {
		localStorage.removeItem('tareas');
		render();
	}
}