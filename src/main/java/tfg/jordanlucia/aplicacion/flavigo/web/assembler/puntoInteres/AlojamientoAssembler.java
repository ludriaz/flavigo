package tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoAlojamiento;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Alojamiento;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.AlojamientoDTO;

public class AlojamientoAssembler {

   
    public static Alojamiento toEntity(AlojamientoDTO dto) {
       
        Alojamiento alojamiento = (Alojamiento) PuntoInteresAssembler.toEntity(dto);

     
        alojamiento.setTipoAlojamiento(TipoAlojamiento.valueOf(dto.getTipoAlojamiento())); 
        
        alojamiento.setServicios(dto.getServicios());

        return alojamiento;
    }

   
    public static AlojamientoDTO toDTO(Alojamiento alojamiento) {
        
        AlojamientoDTO dto = (AlojamientoDTO) PuntoInteresAssembler.toDTO(alojamiento);

      
        dto.setTipoAlojamiento(alojamiento.getTipoAlojamiento().name()); 
       
        dto.setServicios(alojamiento.getServicios());

        return dto;
    }
}