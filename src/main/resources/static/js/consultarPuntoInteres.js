$(document).ready(function() {
	console.log('Script puntosInteres.js cargado');
    var puntosInteresTable = $('#puntosInteresTable').DataTable({
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/admin/PuntoInteres/ConsultarPuntoInteresJSON", // Asegúrate de que esta sea la URL correcta
            "type": "GET",
            "data": function (d) {
                d.nombre = $('#filtroNombre').val();
                d.tipo = $('#filtroTipo').val();
                d.id = $('#filtroId').val();
                //planify(d); // Llamamos a la función planify para modificar la estructura de las columnas
                // DataTables seguirá enviando sus parámetros estándar (draw, start, length, search, order, columns)
            }
        },
        "columns": [
            { "data": "id" },
            { "data": "nombre" },
            { "data": "tipo" },
            { "data": "calle",
              "render": function(data, type, row) {
                  return row.calle + ' ' + row.numero + ', ' + row.localidad;
              }
            },
            { "data": null,
              "render": function(data, type, row) {
                  return 'Lat: ' + row.latitud + ', Lon: ' + row.longitud;
              }
            },
            {
                "data": null,
                "render": function(data, type, row) {
                    return '<button class="btn btn-warning btn-sm" onclick="editar(' + row.id + ')">Editar</button> ' +
                           '<button class="btn btn-danger btn-sm" onclick="borrar(' + row.id + ')">Borrar</button>';
                },
                "orderable": false
            }
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
        }
        puntosInteresTable.ajax.reload();
    });

    $('#filtroId').on('input', function() {
        $(this).removeClass('is-invalid');
    });

    $('#filtroNombre, #filtroTipo, #filtroId').on('keyup', function (e) {
        if (e.key === 'Enter' || e.keyCode === 13) {
            puntosInteresTable.ajax.reload();
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
}