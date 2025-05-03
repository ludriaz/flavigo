package tfg.jordanlucia.aplicacion.flavigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.ParadaRuta;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.Ruta;

public interface ParadaRutaDAOInterface  extends PagingAndSortingRepository<ParadaRuta, Long>{

	ParadaRuta save(ParadaRuta paradaRuta);

	Optional<ParadaRuta> findById(long id);

	void delete(ParadaRuta paradaRuta);

	List<ParadaRuta> findAll();

}
