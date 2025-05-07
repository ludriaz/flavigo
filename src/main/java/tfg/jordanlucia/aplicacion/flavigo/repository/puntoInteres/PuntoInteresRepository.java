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
		        PI.telefono AS telefono,
		        CASE
		            WHEN COM.id IS NOT NULL THEN 'Comercio'
		            WHEN EVE.id IS NOT NULL THEN 'Evento'
		            WHEN ACT.id IS NOT NULL THEN 'Actividad'
		            WHEN BAR.id IS NOT NULL THEN 'Bar_Cafeteria'
		            WHEN RES.id IS NOT NULL THEN 'Restaurante'
		            WHEN ALO.id IS NOT NULL THEN 'Alojamiento'
		            WHEN TUR.id IS NOT NULL THEN 'Turistico'
		            ELSE 'PuntoInteres'
		        END AS tipo
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
		      AND (:tipo IS NULL OR (
		            (:tipo = 'Comercio' AND COM.id IS NOT NULL) OR
		            (:tipo = 'Evento' AND EVE.id IS NOT NULL) OR
		            (:tipo = 'Actividad' AND ACT.id IS NOT NULL) OR
		            (:tipo = 'Bar_Cafeteria' AND BAR.id IS NOT NULL) OR
		            (:tipo = 'Restaurante' AND RES.id IS NOT NULL) OR
		            (:tipo = 'Alojamiento' AND ALO.id IS NOT NULL) OR
		            (:tipo = 'Turistico' AND TUR.id IS NOT NULL) OR
		            (:tipo = 'PuntoInteres' AND COM.id IS NULL AND EVE.id IS NULL AND ACT.id IS NULL 
		                AND BAR.id IS NULL AND RES.id IS NULL AND ALO.id IS NULL AND TUR.id IS NULL)
		        ))
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
		      AND (:tipo IS NULL OR (
		            (:tipo = 'Comercio' AND COM.id IS NOT NULL) OR
		            (:tipo = 'Evento' AND EVE.id IS NOT NULL) OR
		            (:tipo = 'Actividad' AND ACT.id IS NOT NULL) OR
		            (:tipo = 'Bar_Cafeteria' AND BAR.id IS NOT NULL) OR
		            (:tipo = 'Restaurante' AND RES.id IS NOT NULL) OR
		            (:tipo = 'Alojamiento' AND ALO.id IS NOT NULL) OR
		            (:tipo = 'Turistico' AND TUR.id IS NOT NULL) OR
		            (:tipo = 'PuntoInteres' AND COM.id IS NULL AND EVE.id IS NULL AND ACT.id IS NULL 
		                AND BAR.id IS NULL AND RES.id IS NULL AND ALO.id IS NULL AND TUR.id IS NULL)
		        ))
		    """,
		    nativeQuery = true)
			Page<PuntoInteresDTO> findAllWithTipo(
		    @Param("id") Integer id,
		    @Param("nombre") String nombre,
		    @Param("tipo") String tipo,
		    Pageable pageable
		);
}