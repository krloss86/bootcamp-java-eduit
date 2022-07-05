function Item(item) {
	return `<li>${item.id} - ${item.value} 
				<a class="btn btn-warning" role="button" onclick="eliminarItem(${item.id})">Eliminar</a>
			</li>`;
}