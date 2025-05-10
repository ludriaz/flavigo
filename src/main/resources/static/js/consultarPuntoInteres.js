$(document).ready(function() {
    var urlConsultaPuntoInteres = 'http://localhost:8080/admin/PuntoInteres/ConsultarPuntoInteresJSON';
    var urlParams = new URLSearchParams(window.location.search);

    var puntosInteresTable = $('#puntosInteresTable').DataTable({
        "serverSide": true,
        "processing": true,
        "ajax": {
            "url": urlConsultaPuntoInteres,
            "type": "GET",
            "data": function(data) {
                data.nombre = $('#filtroNombre').val();
                data.tipo = $('#filtroTipo').val();
                data.idPuntoInteres = $('#filtroId').val();
                planify(data); // Aplicamos la función planify aquí

                urlParams.forEach(function(value, key) {
                    data[key] = value;
                });
                return data;
            },
            "dataSrc": "data",
            "error": function(xhr, error, thrown) {
                console.error("Error al cargar los puntos de interés:", error);
                $('#puntosInteresTable tbody').html('<tr><td colspan="6" class="text-center">Error al cargar los datos. Por favor, inténtalo de nuevo.</td></tr>');
            }
        },
        "columns": [
            { "data": "id" },
            { "data": "nombre" },
            { "data": "tipo" },
            {
                "data": null,
                "render": function(data, type, row) {
                    return `${row.calle || ''} ${row.numero || ''}, ${row.localidad || ''}`;
                }
            },
            {
                "data": null,
                "render": function(data, type, row) {
                    return `Lat: ${row.latitud}, Long: ${row.longitud}`;
                }
            },
            {
                "data": "id",
                "orderable": false,
                "render": function(data, type, row) {
                    return '<button class="btn btn-sm btn-warning editar me-2" data-id="' + data + '">Editar</button>' +
                           '<a href="#" data-id="' + data + '" class="btn btn-danger btn-sm btn-borrar">Borrar</a>';
                }
            }
        ],
		"columnDefs": [
		    { "targets": 0, "name": "id" },
		    { "targets": 1, "name": "nombre" },
		    { "targets": 2, "name": "tipo" },
		    { "targets": 3, "name": "direccion" },
		    { "targets": 4, "name": "ubicacion" },
		    { "targets": 5, "name": "acciones", "orderable": false, "visible": true }
		],
        "language": {
            "url": "https://cdn.datatables.net/plug-ins/1.13.8/i18n/es-ES.json"
        },
		"searching": false,
        "order": [[0, "asc"]] // Añadido el ordenamiento por la primera columna por defecto
    });

    $('#aplicarFiltros').on('click', function(e) {
        puntosInteresTable.ajax.reload();
    });

    $('#filtroId').on('input', function() {
        $(this).removeClass('is-invalid');
    });

    $('#filtroNombre, #filtroTipo, #filtroId').on('keyup', function(e) {
        if (e.key === 'Enter' || e.keyCode === 13) {
            $('#aplicarFiltros').trigger('click');
        }
    });

    // Eventos de los botones (puedes implementar la lógica de edición/borrado aquí)
    $('#puntosInteresTable tbody').on('click', '.editar', function () {
        var id = $(this).data('id');
        window.location.href = `/admin/PuntoInteres/Editar/${id}`;
    });

    $('#puntosInteresTable').on("click", ".btn-borrar", function (e) {
        var id = $(this).data("id");
        $("#eliminar-id-punto-interes").val(id); // Asegúrate de tener un input con este ID
        $("#eliminar-punto-interes-form").submit(); // Asegúrate de tener un formulario con este ID
    });
});

function planify(data) {
    for (var i = 0; i < data.columns.length; i++) {
        var column = data.columns[i];
        column.searchRegex = column.search.regex;
        column.searchValue = column.search.value;
        delete (column.search);
    }
}