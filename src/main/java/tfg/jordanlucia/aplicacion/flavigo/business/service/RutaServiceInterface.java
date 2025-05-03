package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.RutaModelo;

public interface RutaServiceInterface {

    // Crear una nueva Ruta
    public RutaModelo create(RutaModelo ruta);

    // Actualizar una Ruta existente
    public RutaModelo save(RutaModelo ruta);

    // Eliminar una Ruta por ID
    public void delete(long id);

    // Buscar una Ruta por ID
    public RutaModelo findById(int id);

    // Obtener todas las Rutas
    public List<RutaModelo> findAll();
}
