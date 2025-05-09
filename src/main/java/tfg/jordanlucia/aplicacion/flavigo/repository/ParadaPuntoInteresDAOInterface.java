package tfg.jordanlucia.aplicacion.flavigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Parada;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.ParadaPuntoInteres;

public interface ParadaPuntoInteresDAOInterface extends JpaRepository<ParadaPuntoInteres, Integer>{

}
