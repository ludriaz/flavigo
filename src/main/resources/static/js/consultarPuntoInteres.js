$(document).ready(function() {
    console.log('Script consultarPuntoInteres.js cargado');
	console.log('Elemento #puntosInteresTable encontrado:', $('#puntosInteresTable').length > 0);
	var urlConsultaPuntoInteres ='http://localhost:8080/admin/PuntoInteres/ConsultarPuntoInteresJSON';
    var urlParams = new URLSearchParams(window.location.search); // Lee los parámetros de la URL

	 var puntosInteresTable = $('#puntosInteresTable').DataTable({
	        "serverSide": true,
	        "ajax": {
	            "url": urlConsultaPuntoInteres,
	            "type": "GET",
	            "data": function (data) {
	                data.nombre = $('#filtroNombre').val();
	                data.tipo = $('#filtroTipo').val();
	                data.idPuntoInteres = $('#filtroId').val();

	                urlParams.forEach(function(value, key) {
	                    data[key] = value;
	                });
	                return data;
	            },
	            "dataSrc": "data" // <---- ¡Este es el cambio!
	        },
	        "columns": [
	            { "data": "id" },
	            { "data": "nombre" }
	        ],
	        "columnDefs": [
	            { "targets": 0, "name": "id" },
	            { "targets": 1, "name": "nombre" }
	        ],
	        "language": {
	            "url": "https://cdn.datatables.net/plug-ins/1.13.8/i18n/es-ES.json"
	        }
	    });

	    $('#aplicarFiltros').on('click', function() {
	        var idFiltro = $('#filtroId').val();
	        if (idFiltro !== '' && isNaN(parseInt(idFiltro))) {
	            $('#filtroId').addClass('is-invalid');
	        } else {
	            $('#filtroId').removeClass('is-invalid');
	            puntosInteresTable.ajax.reload();
	        }
	    });

	    $('#filtroId').on('input', function() {
	        $(this).removeClass('is-invalid');
	    });

	    $('#filtroNombre, #filtroTipo, #filtroId').on('keyup', function (e) {
	        if (e.key === 'Enter' || e.keyCode === 13) {
	            $('#aplicarFiltros').trigger('click');
	        }
	    });
	});