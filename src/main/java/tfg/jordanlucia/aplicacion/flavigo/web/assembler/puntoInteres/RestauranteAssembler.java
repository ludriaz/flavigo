package tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.Ambiente;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.RangoPrecios;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoCocina;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Restaurante;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.RestauranteDTO;

public class RestauranteAssembler {

    public static Restaurante toEntity(RestauranteDTO dto) {
        Restaurante restaurante = (Restaurante) PuntoInteresAssembler.toEntity(dto);

        restaurante.setTipoCocina(TipoCocina.valueOf(dto.getTipoCocina()));
        restaurante.setMenuDestacado(dto.getMenuDestacado());
        restaurante.setRangoPrecios(RangoPrecios.valueOf(dto.getRangoPrecios()));
        restaurante.setAmbiente(Ambiente.valueOf(dto.getAmbiente()));

        return restaurante;
    }

    public static RestauranteDTO toDTO(Restaurante restaurante) {
        RestauranteDTO dto = (RestauranteDTO) PuntoInteresAssembler.toDTO(restaurante);

        dto.setTipoCocina(restaurante.getTipoCocina().name());
        dto.setMenuDestacado(restaurante.getMenuDestacado());
        dto.setRangoPrecios(restaurante.getRangoPrecios().name());
        dto.setAmbiente(restaurante.getAmbiente().name());

        return dto;
    }
}