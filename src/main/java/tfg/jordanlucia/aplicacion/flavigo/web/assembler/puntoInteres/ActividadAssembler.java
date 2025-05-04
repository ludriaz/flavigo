package tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.Nivel;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoActividad;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Actividad;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.ActividadDTO;

public class ActividadAssembler {

    public static Actividad toEntity(ActividadDTO dto) {
        Actividad actividad = (Actividad) PuntoInteresAssembler.toEntity(dto);

        actividad.setTipoActividad(TipoActividad.valueOf(dto.getTipoActividad()));
        actividad.setDuracionAproximada(dto.getDuracionAproximada());
        actividad.setNivel(Nivel.valueOf(dto.getNivel()));
        actividad.setPrecioEntrada(dto.getPrecioEntrada());

        return actividad;
    }

    public static ActividadDTO toDTO(Actividad actividad) {
        ActividadDTO dto = (ActividadDTO) PuntoInteresAssembler.toDTO(actividad);

        dto.setTipoActividad(actividad.getTipoActividad().name());
        dto.setDuracionAproximada(actividad.getDuracionAproximada());
        dto.setNivel(actividad.getNivel().name());
        dto.setPrecioEntrada(actividad.getPrecioEntrada());

        return dto;
    }
}