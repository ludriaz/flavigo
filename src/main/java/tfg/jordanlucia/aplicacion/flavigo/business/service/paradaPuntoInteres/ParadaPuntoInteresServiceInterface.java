package tfg.jordanlucia.aplicacion.flavigo.business.service.paradaPuntoInteres;

import java.util.List;

import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaPuntoInteresModelo;

public interface ParadaPuntoInteresServiceInterface {
	 // Crear una nueva empresa
    public ParadaPuntoInteresModelo create(ParadaPuntoInteresModelo ParadaPuntoInteres);

    // Actualizar una empresa existente
    public ParadaPuntoInteresModelo save(ParadaPuntoInteresModelo ParadaPuntoInteres);

    // Eliminar una empresa por ID
    public void delete(Integer id);

    // Buscar una empresa por ID
    public ParadaPuntoInteresModelo findById(Integer id);

    // Obtener todas las empresas
    public List<ParadaPuntoInteresModelo> findAll();
}
