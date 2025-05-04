package tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.Ambiente;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.BarCafeteria;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.BarCafeteriaDTO;

public class BarCafeteriaAssembler {

    public static BarCafeteria toEntity(BarCafeteriaDTO dto) {
        BarCafeteria barCafeteria = (BarCafeteria) PuntoInteresAssembler.toEntity(dto);

        barCafeteria.setAmbiente(Ambiente.valueOf(dto.getAmbiente()));
        barCafeteria.setEspecialidades(dto.getEspecialidades());

        return barCafeteria;
    }

    public static BarCafeteriaDTO toDTO(BarCafeteria barCafeteria) {
        BarCafeteriaDTO dto = (BarCafeteriaDTO) PuntoInteresAssembler.toDTO(barCafeteria);

        dto.setAmbiente(barCafeteria.getAmbiente().name());
        dto.setEspecialidades(barCafeteria.getEspecialidades());

        return dto;
    }
}