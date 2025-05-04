package tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Evento;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.EventoDTO;

public class EventoAssembler {
	 
    public static Evento toEntity(EventoDTO dto) {
        Evento evento = (Evento) PuntoInteresAssembler.toEntity(dto);

        evento.setTipoEvento(dto.getTipoEvento());
        evento.setFechaInicio(dto.getFechaInicio());
        evento.setFechaFin(dto.getFechaFin());
        evento.setNombreOrganizador(dto.getNombreOrganizador());

        return evento;
    }

    
    public static EventoDTO toDTO(Evento evento) {
        EventoDTO dto = (EventoDTO) PuntoInteresAssembler.toDTO(evento);

        dto.setTipoEvento(evento.getTipoEvento());
        dto.setFechaInicio(evento.getFechaInicio());
        dto.setFechaFin(evento.getFechaFin());
        dto.setNombreOrganizador(evento.getNombreOrganizador());

        return dto;
    }
}