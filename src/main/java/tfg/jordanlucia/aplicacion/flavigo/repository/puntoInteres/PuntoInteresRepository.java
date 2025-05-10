package tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;

@Repository
public interface PuntoInteresRepository extends JpaRepository<PuntoInteres, Integer> {

	
	   @Query(
	            value = "SELECT p FROM PuntoInteres p " +
	                    "WHERE (:idPuntoInteres IS NULL OR CAST(p.id AS string) LIKE CONCAT('%', :idPuntoInteres, '%')) " +
	                    "AND (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
	                    "AND (:tipo IS NULL OR LOWER(CAST(p.tipo AS string)) LIKE LOWER(CONCAT('%', :tipo, '%')))",

	            countQuery = "SELECT COUNT(p) FROM PuntoInteres p " +
	                    "WHERE (:idPuntoInteres IS NULL OR CAST(p.id AS string) LIKE CONCAT('%', :idPuntoInteres, '%')) " +
	                    "AND (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
	                    "AND (:tipo IS NULL OR LOWER(CAST(p.tipo AS string)) LIKE LOWER(CONCAT('%', :tipo, '%')))"
	    )
	    Page<PuntoInteres> findByFilter(
	            @Param("idPuntoInteres") Integer idPuntoInteres,
	            @Param("nombre") String nombre,
	            @Param("tipo") String tipo,
	            Pageable pageable
	    );

	Optional<PuntoInteres> findByNombre(String nombre);

	
}