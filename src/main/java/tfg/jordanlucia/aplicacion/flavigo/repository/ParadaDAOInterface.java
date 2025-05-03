package tfg.jordanlucia.aplicacion.flavigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Parada;



public interface ParadaDAOInterface extends PagingAndSortingRepository<Parada, Long>{

	Parada save(Parada parada);

	Optional<Parada> findById(long id);

	void delete(Parada parada);

	List<Parada> findAll();

}
