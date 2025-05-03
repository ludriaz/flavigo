package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaRutaModelo;

public interface ParadaRutaServiceInterface {

    // Crear una nueva ParadaRuta
    public ParadaRutaModelo create(ParadaRutaModelo paradaRuta);

    // Actualizar una ParadaRuta existente
    public ParadaRutaModelo save(ParadaRutaModelo paradaRuta);

    // Eliminar una ParadaRuta por ID
    public void delete(long id);

    // Buscar una ParadaRuta por ID
    public ParadaRutaModelo findById(int id);

    // Obtener todas las ParadaRuta
    public List<ParadaRutaModelo> findAll();
}
