<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Alta de producto</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="" method="POST" id="frmArticulo">
			  <div class="mb-3">
			    <label 
			    	for="titulo" 
			    	class="form-label">Título</label>
			    <input type="text" class="form-control" 
			    	id="titulo" 
			    	name="titulo">
			  </div>
			  <div class="mb-3">
			    <label for="codigo" class="form-label">Código</label>
			    <input type="text" class="form-control" 
			    	id="codigo"
			    	name="codigo">
			  </div>
			  <div class="mb-3">
			    <label for="precio" class="form-label">Precio</label>
			    <input type="number" min="0" 
			    	class="form-control" 
			    	id="precio"
			    	name="precio">
			  </div>
			  <div class="mb-3">
			    <label for="stock" class="form-label">Stock</label>
			    <input type="text" class="form-control" 
			    	id="stock"
			    	name="stock">
			  </div>
			  <div class="mb-3">
			  	<label for="marcas" class="form-label">Marcas</label>
				<select class="form-select" aria-label="Marcas" 
					id="marcas"
					name="marcaId">
					<!-- crear los elementos por medio del DOM  -->
				</select>			  
			  </div>
			  <div class="mb-3">
			  	<label for="categorias" class="form-label">Categorias</label>
				<select class="form-select" aria-label="Categorias" 
					id="categorias"
					name="categoriaId">
				</select>			  
			  </div>
			  <button type="submit" class="btn btn-primary">Grabar</button>
		</form>
      </div>
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button> -->
<!--         <button type="button" class="btn btn-primary">Understood</button> -->
<!--       </div> -->
    </div>
  </div>
</div>
<script>
	/*const msj = {
		type:'error',
		msj: error.message
	};*/
	function Message(message) {
		const divError = document.getElementById('divError');
		const alert = `
		<div class="alert alert-${message.type} alert-dismissible fade show" role="alert">
		    <strong>${message.msj}</strong>
		    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div> 
		`;
		divError.innerHTML = alert;
	}
	
	async function openAltaModal(id) {
		var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop'), {
			  keyboard: false
		});
		
		const action = id ? '/controllers/EditarController' : 'controller/CrearArticuloController';  
		
		//invocar a nuestro back, esperar obtener el json con las categorias y las marcas
		const response = await axios.get(`<%=request.getContextPath()%>/api/AltaDatosController`);
       	Categorias(response.data.categorias);
       	Marcas(response.data.marcas);
       	
       	//cambiar el action 
       	document.getElementById('frmArticulo').action = `<%=request.getContextPath()%>/${action}`;
	
       	//si id esta informado => desactivar el campo codigo
       	if(id) {
       		document.getElementById('codigo').disabled = 'disabled'
       		const articulo = await getProducto(id);
       		llenarFormulario(articulo);
       	}else{
       		document.getElementById('codigo').disabled = ''
       	}
       	
       	//llenar los datos del formulario
       	
       	//mostrar modal
       	myModal.show();
	}
	
	function llenarFormulario(articulo) {
		console.log(articulo);
	}
	
	async function getProducto(id) {
		return await axios.get(`<%=request.getContextPath()%>/controller/EditarController?id=${id}`);        		
	}
	
	function Categorias(categorias) {
		debugger;
		llenarLista('categorias',categorias);
	}
	
	function Marcas(categorias) {
		llenarLista('marcas', categorias);		
	}
	
	function llenarLista(id,lista) {
		const htmlSelect = document.getElementById(id);	
		if(lista.length > 0) {
			for(const aux of lista) {
				if(aux.habilitada === 1) {
					const option = document.createElement('option');
// 					option.id = aux.id;
					option.value = aux.id;
					option.text = aux.descripcion; 
					htmlSelect.appendChild(option);
				}
			}
		}
	}
</script>