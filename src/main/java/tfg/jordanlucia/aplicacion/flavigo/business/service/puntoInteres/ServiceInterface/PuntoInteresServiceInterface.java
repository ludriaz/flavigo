package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres.ServiceInterface;


	import java.util.List;
	import java.util.Optional;

import org.springframework.data.domain.Page;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;
import tfg.jordanlucia.aplicacion.flavigo.web.model.PuntoInteresFilter;

	public interface PuntoInteresServiceInterface {

		/**
	     * Crea un nuevo Punto de Interés.
	     * @param dto El DTO del punto de interés a crear.
	     * @return `true` si el punto de interés se creó correctamente, `false` en caso contrario.
	     */
	    boolean createPuntoInteres(PuntoInteresDTO dto);

	    /**
	     * Borra un Punto de Interés por su ID.
	     * @param id El ID del punto de interés a borrar.
	     */
	    void deletePuntoInteres(int id);

	    /**
	     * Edita un Punto de Interés existente.
	     * @param dto El DTO del punto de interés con los datos actualizados.
	     * @return `true` si el punto de interés se editó correctamente, `false` en caso contrario.
	     */
	    boolean edit(PuntoInteresDTO dto);

	    /**
	     * Encuentra un Punto de Interés por su ID y lo devuelve como un DTO.
	     * @param id El ID del punto de interés a buscar.
	     * @return El `PuntoInteresDTO` correspondiente al ID, o `null` si no se encuentra.
	     */
	    PuntoInteresDTO findPuntoInteresDTOById(int id);

	    /**
	     * Encuentra un Punto de Interés por su nombre.
	     * @param nombre El nombre del punto de interés a buscar.
	     * @return El `PuntoInteres` correspondiente al nombre, o `null` si no se encuentra.
	     */
	    PuntoInteres findByNombre(String nombre);

	    /**
	     * Devuelve una lista de todos los Puntos de Interés.
	     * @return Un iterable de `PuntoInteres` con todos los puntos de interés.
	     */
	    Iterable<PuntoInteres> findALL();

	    /**
	     * Devuelve una lista paginada de Puntos de Interés filtrados según el criterio proporcionado.
	     * @param filtro El objeto `PuntoInteresFilter` que contiene los criterios de búsqueda y paginación.
	     * @return Una página de `PuntoInteresDTO` que coinciden con el filtro.
	     */
	    Page<PuntoInteresDTO> search(PuntoInteresFilter filtro);

	    /**
	     * Encuentra un Punto de Interés por su ID y lo devuelve como una entidad.
	     * @param id El ID del punto de interés a buscar.
	     * @return El `PuntoInteres` correspondiente al ID, o `null` si no se encuentra.
	     */
	    PuntoInteresDTO findById(int id);
	
	}

