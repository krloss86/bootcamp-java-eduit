<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Alta de producto</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="<%=request.getContextPath()%>/controller/CrearArticuloController" method="POST">
			  <div class="mb-3">
			    <label for="titulo" class="form-label">Título</label>
			    <input type="text" class="form-control" id="titulo">
			  </div>
			  <div class="mb-3">
			    <label for="codigo" class="form-label">Código</label>
			    <input type="text" class="form-control" id="codigo">
			  </div>
			  <div class="mb-3">
			    <label for="precio" class="form-label">Precio</label>
			    <input type="number" min="0" class="form-control" id="precio">
			  </div>
			  <div class="mb-3">
			    <label for="stock" class="form-label">Stock</label>
			    <input type="text" class="form-control" id="stock">
			  </div>
			  <div class="mb-3">
			  	<label for="marcas" class="form-label">Marcas</label>
				<select class="form-select" aria-label="Marcas" id="marcas">
					<!-- crear los elementos por medio del DOM  -->
				</select>			  
			  </div>
			  <div class="mb-3">
			  	<label for="categorias" class="form-label">Categorias</label>
				<select class="form-select" aria-label="Categorias" id="categorias">
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
	function openAltaModal() {
		var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop'), {
			  keyboard: false
		});
		
		//invocar a nuestro back, esperar obtener el json con las categorias y las marcas
		axios.get(`<%=request.getContextPath()%>/api/AltaDatosController`)
          .then(function (response) {        	  
//            alert(response.data.categorias);
         	  
         	  Categorias(response.data.categorias);
         	  Marcas(response.data.marcas);
         	  
        	  myModal.show();  
          })
          .catch(function (error) {
              
          })
          .then(function () {
              console.log("buscando lista de usuarios...")
          });
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