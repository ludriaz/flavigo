package tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoTuristico;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Turistico;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.TuristicoDTO;

public class TuristicoAssembler {

    public static Turistico toEntity(TuristicoDTO dto) {
        Turistico turistico = (Turistico) PuntoInteresAssembler.toEntity(dto);

        turistico.setTipoTuristico(TipoTuristico.valueOf(dto.getTipoTuristico()));

        return turistico;
    }

    public static TuristicoDTO toDTO(Turistico turistico) {
        TuristicoDTO dto = (TuristicoDTO) PuntoInteresAssembler.toDTO(turistico);

        dto.setTipoTuristico(turistico.getTipoTuristico().name());

        return dto;
    }
}