package tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres;

import java.util.List;

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

	
	@Query(value = """
		    SELECT 
		        PI.id AS id,
		        PI.nombre AS nombre,
		        PI.descripcion_breve AS descripcionBreve,
		        PI.descripcion_detallada AS descripcionDetallada,
		        PI.latitud AS latitud,
		        PI.longitud AS longitud,
		        PI.calle AS calle,
		        PI.numero AS numero,
		        PI.localidad AS localidad,
		        PI.url AS url,
		        PI.imagen AS imagen,
		        PI.horario_apertura_manana AS horarioAperturaManana,
		        PI.horario_apertura_tarde AS horarioAperturaTarde,
		        PI.horario_cierre_manana AS horarioCierreManana,
		        PI.horario_cierre_tarde AS horarioCierreTarde,
		        PI.etiquetas AS etiquetas,
		        PI.telefono AS telefono
		    FROM TD_PUNTO_INTERES PI
		    LEFT JOIN TD_COMERCIO COM ON PI.id = COM.id
		    LEFT JOIN TD_EVENTO EVE ON PI.id = EVE.id
		    LEFT JOIN TD_ACTIVIDAD ACT ON PI.id = ACT.id
		    LEFT JOIN TD_BAR_CAFETERIA BAR ON PI.id = BAR.id
		    LEFT JOIN TD_RESTAURANTE RES ON PI.id = RES.id
		    LEFT JOIN TD_ALOJAMIENTO ALO ON PI.id = ALO.id
		    LEFT JOIN TD_TURISTICO TUR ON PI.id = TUR.id
		    WHERE (:id IS NULL OR PI.id = :id)
		      AND (:nombre IS NULL OR LOWER(PI.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
		    """,
		    countQuery = """
		    SELECT COUNT(*) FROM TD_PUNTO_INTERES PI
		    LEFT JOIN TD_COMERCIO COM ON PI.id = COM.id
		    LEFT JOIN TD_EVENTO EVE ON PI.id = EVE.id
		    LEFT JOIN TD_ACTIVIDAD ACT ON PI.id = ACT.id
		    LEFT JOIN TD_BAR_CAFETERIA BAR ON PI.id = BAR.id
		    LEFT JOIN TD_RESTAURANTE RES ON PI.id = RES.id
		    LEFT JOIN TD_ALOJAMIENTO ALO ON PI.id = ALO.id
		    LEFT JOIN TD_TURISTICO TUR ON PI.id = TUR.id
		    WHERE (:id IS NULL OR PI.id = :id)
		      AND (:nombre IS NULL OR LOWER(PI.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
		    """,
		    nativeQuery = true)
			Page<PuntoInteres> findAllWithTipo(
					@Param("id") Integer id,
					@Param("nombre") String nombre,
					Pageable pageable
		);
}