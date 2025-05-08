$(document).ready(function() {
    console.log('Script consultarPuntoInteres.js cargado');
    console.log('Elemento #puntosInteresTable encontrado:', $('#puntosInteresTable').length > 0);
    
    var urlConsultaPuntoInteres = 'http://localhost:8080/admin/PuntoInteres/ConsultarPuntoInteresJSON';
    var urlParams = new URLSearchParams(window.location.search);

    var puntosInteresTable = $('#puntosInteresTable').DataTable({
        "serverSide": true,
        "ajax": {
            "url": urlConsultaPuntoInteres,
            "type": "GET",
            "data": function(data) {
                data.nombre = $('#filtroNombre').val();
                data.tipo = $('#filtroTipo').val();
                data.idPuntoInteres = $('#filtroId').val();

                urlParams.forEach(function(value, key) {
                    data[key] = value;
                });
                return data;
            },
            "dataSrc": "data"
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
                "data": null,
                "orderable": false,
                "searchable": false,
                "render": function(data, type, row) {
                    return `
                        <button class="btn btn-sm btn-warning editar" data-id="${row.id}">Editar</button>
                        <button class="btn btn-danger btn-sm borrar" data-id="${row.id}">Borrar</button>
                    `;
                }
            }
        ],
		"columnDefs": [
		    { "targets": 0, "name": "id" },
		    { "targets": 1, "name": "nombre" },
		    { "targets": 2, "name": "tipo" },
		    { "targets": 3, "name": "direccion" },
		    { "targets": 4, "name": "ubicacion" },
		    { "targets": 5, "orderable": false, "searchable": false, "name": "acciones" }
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

    $('#puntosInteresTable tbody').on('click', '.borrar', function () {
        var id = $(this).data('id');
        if (confirm('¿Estás seguro de que deseas borrar este punto de interés?')) {
            // Realizar la petición DELETE o redirigir
            window.location.href = `/admin/PuntoInteres/Borrar/${id}`;
        }
    });
});
