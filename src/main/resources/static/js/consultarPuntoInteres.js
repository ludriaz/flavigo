$(document).ready(function() {
	$(document).ready(function() {
	    console.log('Script consultarPuntoInteres.js cargado');

	    var urlConsultaPuntoInteres = "/admin/PuntoInteres/ConsultarPuntoInteresJSON";
	    var urlParams = new URLSearchParams(window.location.search); // Lee los parámetros de la URL

	    var puntosInteresTable = $('#puntosInteresTable').DataTable({
	        "processing": true,
	        "serverSide": true,
	        "ajax": {
	            "url": urlConsultaPuntoInteres,
	            "type": "GET",
	            "data": function (data) {
	                data.nombre = $('#filtroNombre').val();
	                data.tipo = $('#filtroTipo').val();
	                data.id = $('#filtroId').val();

	                // Agrega los parámetros de la URL al objeto de datos si existen
	                urlParams.forEach(function(value, key) {
	                    data[key] = value;
	                });
	                planify(data); // Aplicamos la función planify
	            }
	        },
	        "columns": [
	            { "data": "id" },
	            { "data": "nombre" },
	            { "data": "tipo" },
	            {
	                "data": null,
	                "render": function(data, type, row) {
	                    return row.calle + ' ' + row.numero + ', ' + row.localidad;
	                },
	                "name": "direccionCompleta" // Puedes personalizar el nombre si lo necesitas
	            },
	            {
	                "data": null,
	                "render": function(data, type, row) {
	                    return 'Lat: ' + row.latitud + ', Lon: ' + row.longitud;
	                },
	                "name": "coordenadas" // Puedes personalizar el nombre si lo necesitas
	            },
	            {
	                "data": null,
	                "render": function(data, type, row) {
	                    var linkEditar = '<button class="btn btn-warning btn-sm" onclick="editar(' + row.id + ')">Editar</button> ';
	                    var linkBorrar = $('<a/>').attr("href", "#").attr("data-id", row.id).text("Borrar")[0].outerHTML;
	                    return linkEditar + linkBorrar;
	                },
	                "orderable": false,
	                "name": "acciones" // Puedes personalizar el nombre si lo necesitas
	            }
	        ],
	        "columnDefs": [
	            { "targets": 0, "name": "id" },
	            { "targets": 1, "name": "nombre" },
	            { "targets": 2, "name": "tipo" },
	            // La dirección y las coordenadas no tienen un "data" directo, así que usamos el "name" definido en "columns"
	            { "targets": 3, "orderable": true }, // Dirección
	            { "targets": 4, "orderable": false }, // Coordenadas (generalmente no ordenables)
	            { "targets": 5, "orderable": false }  // Acciones
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

	function editar(id) {
	    console.log('Editar punto de interés con ID: ' + id);
	    // Aquí iría la lógica para editar
	}

	function borrar(id) {
	    console.log('Borrar punto de interés con ID: ' + id);
	    // Aquí iría la lógica para borrar
	}

	function planify(data) {
	    for (var i = 0; i < data.columns.length; i++) {
	        var column = data.columns[i];
	        column.searchRegex = column.search.regex;
	        column.searchValue = column.search.value;
	        delete(column.search);
	    }
	}});