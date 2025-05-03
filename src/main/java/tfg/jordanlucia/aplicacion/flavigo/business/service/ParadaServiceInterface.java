package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaModelo;

public interface ParadaServiceInterface {

    // Crear una nueva parada
    public ParadaModelo create(ParadaModelo parada);

    // Actualizar una parada existente
    public ParadaModelo save(ParadaModelo parada);

    // Eliminar una parada por ID
    public void delete(long id);

    // Buscar una parada por ID
    public ParadaModelo findById(int id);

    // Obtener todas las paradas
    public List<ParadaModelo> findAll();
}
