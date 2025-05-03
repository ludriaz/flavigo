package tfg.jordanlucia.aplicacion.flavigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;


import tfg.jordanlucia.aplicacion.flavigo.model.entity.Ruta;

public interface RutaDAOInterface extends PagingAndSortingRepository<Ruta, Long>{

	Ruta save(Ruta ruta);

	Optional<Ruta> findById(long id);

	void delete(Ruta ruta);

	List<Ruta> findAll();

}
