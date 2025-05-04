package tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.CategoriaComercio;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Comercio;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.ComercioDTO;

public class ComercioAssembler {

 
    public static Comercio toEntity(ComercioDTO dto) {
     
        Comercio comercio = (Comercio) PuntoInteresAssembler.toEntity(dto);

     
        comercio.setCategoria(CategoriaComercio.valueOf(dto.getTipoComercio())); 
        comercio.setProductos(dto.getProductosDestacados());

        return comercio;
    }

  
    public static ComercioDTO toDTO(Comercio comercio) {
      
        ComercioDTO dto = (ComercioDTO) PuntoInteresAssembler.toDTO(comercio);

  
        dto.setTipoComercio(comercio.getCategoria().name()); 
        dto.setProductosDestacados(comercio.getProductos());

        return dto;
    }
}