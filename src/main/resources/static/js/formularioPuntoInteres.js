
$(document).ready(function() {
    $('#tipo').change(function() {
        var tipoSeleccionado = $(this).val();
        $('#camposDinamicosModal').modal('show');
        cargarCamposDinamicos(tipoSeleccionado);
    });

    $('#guardarCamposDinamicos').click(function() {
        $('#camposDinamicosModal').modal('hide');
        // Los valores del modal se actualizarán directamente en el formulario antes del submit
    });

    $('form').submit(function() {
        // Antes de enviar, asegúrate de que los campos dinámicos correspondan al tipo seleccionado
        var tipoFinal = $('#tipo').val();
        $('.campo-dinamico').each(function() {
            var nombreCampo = $(this).attr('name');
            if (!nombreCampo.startsWith(tipoFinal + '_')) {
                $(this).remove(); // Elimina campos que no coinciden con el tipo
            }
        });
        return true; // Permite el envío del formulario
    });

    function cargarCamposDinamicos(tipo) {
        var modalBody = $('#modal-body-campos-dinamicos');
        modalBody.empty(); // Limpia los campos anteriores
        if (tipo === 'Comercio') {
            modalBody.append(`
                <div class="mb-3">
                    <label class="form-label">Categoría</label>
                    <select class="form-select campo-dinamico" name="Comercio_categoria">
                        <option value="MODA">Moda</option>
                        <option value="ALIMENTACION">Alimentación</option>
                        <option value="ELECTRONICA">Electrónica</option>
                        <option value="LIBRERIA">Librería</option>
                        <option value="DEPORTES">Deportes</option>
                        <option value="OTROS">Otros</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Productos Principales</label>
                    <textarea class="form-control campo-dinamico" name="Comercio_productos" rows="2"></textarea>
                </div>
            `);
        } else if (tipo === 'Evento') {
            modalBody.append(`
                <div class="mb-3">
                    <label class="form-label">Tipo de Evento</label>
                    <select class="form-select campo-dinamico" name="Evento_tipoEvento">
                        <option value="concierto">Concierto</option>
                        <option value="teatro">Teatro</option>
                        <option value="festival">Festival</option>
                        <option value="feria">Feria</option>
                        <option value="exposicion">Exposición</option>
                        <option value="conferencia">Conferencia</option>
                        <option value="cultural">Cultural</option>
                        <option value="deportivo">Deportivo</option>
                        <option value="educativo">Educativo</option>
                        <option value="musical">Musical</option>
                        <option value="gastronomico">Gastronómico</option>
                        <option value="fiesta_popular">Fiesta Popular</option>
                        <option value="otros">Otros</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Fecha Inicio</label>
                    <input type="datetime-local" class="form-control campo-dinamico" name="Evento_fechaInicio">
                </div>
                <div class="mb-3">
                    <label class="form-label">Fecha Fin</label>
                    <input type="datetime-local" class="form-control campo-dinamico" name="Evento_fechaFin">
                </div>
                <div class="mb-3">
                    <label class="form-label">Organizador</label>
                    <input type="text" class="form-control campo-dinamico" name="Evento_nombreOrganizador">
                </div>
            `);
        } else if (tipo === 'Actividad') {
            modalBody.append(`
                <div class="mb-3">
                    <label class="form-label">Tipo de Actividad</label>
                    <select class="form-select campo-dinamico" name="Actividad_tipoActividad">
                        <option value="deportiva">Deportiva</option>
                        <option value="cultural">Cultural</option>
                        <option value="aventura">Aventura</option>
                        <option value="relajante">Relajante</option>
                        <option value="gastronómica">Gastronómica</option>
                        <option value="turística">Turística</option>
                        <option value="otros">Otros</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Duración Aproximada (minutos)</label>
                    <input type="number" class="form-control campo-dinamico" name="Actividad_duracionAproximada" min="0">
                </div>
                <div class="mb-3">
                    <label class="form-label">Nivel</label>
                    <select class="form-select campo-dinamico" name="Actividad_nivel">
                        <option value="facil">Fácil</option>
                        <option value="medio">Medio</option>
                        <option value="dificil">Difícil</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Precio Entrada</label>
                    <input type="number" class="form-control campo-dinamico" name="Actividad_precioEntrada" step="0.01" min="0">
                </div>
            `);
        } else if (tipo === 'Bar_Cafeteria') {
            modalBody.append(`
                <div class="mb-3">
                    <label class="form-label">Ambiente</label>
                    <select class="form-select campo-dinamico" name="Bar_Cafeteria_ambiente">
                        <option value="tranquilo">Tranquilo</option>
                        <option value="familiar">Familiar</option>
                        <option value="moderno">Moderno</option>
                        <option value="tradicional">Tradicional</option>
                        <option value="festivo">Festivo</option>
                        <option value="romantico">Romántico</option>
                        <option value="otros">Otros</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Especialidades</label>
                    <textarea class="form-control campo-dinamico" name="Bar_Cafeteria_especialidades" rows="2"></textarea>
                </div>
            `);
        } else if (tipo === 'Restaurante') {
            modalBody.append(`
                <div class="mb-3">
                    <label class="form-label">Tipo de Cocina</label>
                    <select class="form-select campo-dinamico" name="Restaurante_tipoCocina">
                        <option value="TRADICIONAL">Tradicional</option>
                        <option value="MODERNA">Moderna</option>
                        <option value="INTERNACIONAL">Internacional</option>
                        <option value="FUSION">Fusión</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Menú Destacado</label>
                    <textarea class="form-control campo-dinamico" name="Restaurante_menuDestacado" rows="2"></textarea>
                </div>
                <div class="mb-3">
                    <label class="form-label">Rango de Precios</label>
                    <select class="form-select campo-dinamico" name="Restaurante_rangoPrecios">
                        <option value="BAJO">Bajo</option>
                        <option value="MEDIO">Medio</option>
                        <option value="ALTO">Alto</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Ambiente</label>
                    <select class="form-select campo-dinamico" name="Restaurante_ambiente">
                        <option value="tranquilo">Tranquilo</option>
                        <option value="familiar">Familiar</option>
                        <option value="moderno">Moderno</option>
                        <option value="tradicional">Tradicional</option>
                        <option value="festivo">Festivo</option>
                        <option value="romantico">Romántico</option>
                        <option value="otros">Otros</option>
                    </select>
                </div>
            `);
        } else if (tipo === 'Alojamiento') {
            modalBody.append(`
                <div class="mb-3">
                    <label class="form-label">Tipo de Alojamiento</label>
                    <select class="form-select campo-dinamico" name="Alojamiento_tipoAlojamiento">
                        <option value="hotel">Hotel</option>
                        <option value="hostal">Hostal</option>
                        <option value="pensión">Pensión</option>
                        <option value="apartamento">Apartamento</option>
                        <option value="camping">Camping</option>
                        <option value="albergue">Albergue</option>
                        <option value="otros">Otros</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label">Servicios</label>
                    <textarea class="form-control campo-dinamico" name="Alojamiento_servicios" rows="3"></textarea>
                </div>
            `);
        } else if (tipo === 'Turistico') {
            modalBody.append(`
                <div class="mb-3">
                    <label class="form-label">Tipo de Recurso Turístico</label>
                    <select class="form-select campo-dinamico" name="Turistico_tipoTuristico">
                        <option value="monumento">Monumento</option>
                        <option value="arquitectura">Arquitectura</option>
                        <option value="mirador">Mirador</option>
                        <option value="zona_natural">Zona Natural</option>
                        <option value="zona_arqueologica">Zona Arqueológica</option>
                        <option value="punto_emblematico">Punto Emblemático</option>
                        <option value="playa">Playa</option>
                        <option value="parque">Parque</option>
                        <option value="otros">Otros</option>
                    </select>
                </div>
            `);
        } else if (tipo === 'PuntoInteres') {
            modalBody.append(`
                <div class="mb-3">
                    <label class="form-label">Categoría</label>
                    <input type="text" class="form-control campo-dinamico" name="PuntoInteres_categoria">
                </div>
                <div class="mb-3">
                    <label class="form-label">Valoración Media</label>
                    <input type="number" class="form-control campo-dinamico" name="PuntoInteres_valoracion" step="0.1" min="0" max="5">
                </div>
            `);
        }
    
        // Puedes añadir más condiciones 'else if' para otros tipos si necesitas campos adicionales
    }
});

