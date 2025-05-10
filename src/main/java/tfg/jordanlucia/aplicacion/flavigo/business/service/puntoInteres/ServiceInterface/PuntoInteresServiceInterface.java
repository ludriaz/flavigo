package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres.ServiceInterface;


	import java.util.List;
	import java.util.Optional;

import org.springframework.data.domain.Page;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;
import tfg.jordanlucia.aplicacion.flavigo.web.model.PuntoInteresFilter;

	public interface PuntoInteresServiceInterface {

	    PuntoInteres guardar(PuntoInteres puntoInteres);

	    Optional<PuntoInteres> buscarPorId(Integer id);

	    List<PuntoInteres> buscarTodos();

	    void eliminarPorId(Integer id);

	    Iterable<PuntoInteresDTO> findALL();
	    
	    public Page<PuntoInteres> search(PuntoInteresFilter filtro);

		PuntoInteres findById(int id);
	}

