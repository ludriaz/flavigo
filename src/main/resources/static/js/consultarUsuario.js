$(document).ready(function() {
    var urlConsultaUsuarios = 'http://localhost:8080/admin/Usuario/ConsultarUsuarioJSON';

    var tablaResultados = $('#tablaUsuarios').DataTable({
        "ajax": {
            "url": urlConsultaUsuarios,
            "data": function (data) {
                // Aquí también puedes incluir los parámetros de filtro que DataTables envía por defecto
                data.id = $("#filtroIdUsuario").val();
                data.nombre = $("#filtroNombreUsuario").val();
                data.email = $("#filtroEmailUsuario").val();
                data.rol = $("#filtroRolUsuario").val();
                planify(data);
            }
        },
        "processing": true,
        "serverSide": true,
        "ordering": true,
		"searching": false,
        "order": [[0, "asc"]],
		"columns": [
		            { "data": "id" },
		            { "data": "nombre" },
		            { "data": "email" },
		            { "data": "rol" },
		            {
		                "data": "id",
		                "orderable": false,
		                "render": function (data, type, row) {
		                    // Modificamos la función render para crear un enlace en lugar de un botón
		                    return '<a href="/admin/Usuario/formularioEditarUsuario?id=' + data + '" class="btn btn-warning btn-sm me-2">Editar</a>' +
		                           '<a href="#" data-id="' + data + '" class="btn btn-danger btn-sm btn-borrar">Borrar</a>';
		                }
		            }
		        ],
		        "columnDefs": [
		            { "targets": 0, "name": "id" },
		            { "targets": 1, "name": "nombre" },
		            { "targets": 2, "name": "email" },
		            { "targets": 3, "name": "rol" },
		            { "targets": 4, "name": "acciones", "orderable": false, "visible": true }
		        ]
    });

    $('#aplicarFiltrosBtn').on('click', function (e) {
        // No necesitas preventDefault ni stopPropagation aquí ya que no es un submit de formulario
        tablaResultados.ajax.reload(); // Recarga la tabla, DataTables volverá a llamar a la función "data" del ajax
    });

    $('#limpiarFiltrosBtn').on('click', function () {
        $('#filtroUsuariosForm')[0].reset(); // Limpia el formulario
        tablaResultados.ajax.reload(); // Recarga la tabla sin los filtros aplicados
    });


    $('#tablaUsuarios').on("click", ".btn-borrar", function (e) {
        var id = $(this).data("id");
        $("#eliminar-id").val(id);
        $("#eliminar-form").submit();
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
