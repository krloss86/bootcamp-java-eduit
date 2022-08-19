/*
Componente
*/
function App(){
	renderApp(root);
}

/*funciones */
function renderApp(divRoot) {
	divRoot.innerHTML = Container();
	render();	
}

function render() {
	const divTareas = document.getElementById('tareas');

	let tareasInLocalStorage = getTareas();
	
	divTareas.innerHTML = List(tareasInLocalStorage);
}