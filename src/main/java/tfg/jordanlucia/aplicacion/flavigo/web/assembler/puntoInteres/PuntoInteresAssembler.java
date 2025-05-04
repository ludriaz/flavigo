package tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;

public class PuntoInteresAssembler {

 
    public static PuntoInteresDTO toDTO(PuntoInteres puntoInteres) {
        PuntoInteresDTO dto = new PuntoInteresDTO();

     
        dto.setId(puntoInteres.getId());
        dto.setNombre(puntoInteres.getNombre());
        dto.setDescripcionBreve(puntoInteres.getDescripcionBreve());
        dto.setDescripcionDetallada(puntoInteres.getDescripcionDetallada());
        dto.setLatitud(puntoInteres.getLatitud());
        dto.setLongitud(puntoInteres.getLongitud());
        dto.setCalle(puntoInteres.getCalle());
        dto.setNumero(puntoInteres.getNumero());
        dto.setLocalidad(puntoInteres.getLocalidad());
        dto.setUrl(puntoInteres.getUrl());
        dto.setImagen(puntoInteres.getImagen());
        dto.setHorarioAperturaManana(puntoInteres.getHorarioAperturaManana());
        dto.setHorarioAperturaTarde(puntoInteres.getHorarioAperturaTarde());
        dto.setHorarioCierreManana(puntoInteres.getHorarioCierreManana());
        dto.setHorarioCierreTarde(puntoInteres.getHorarioCierreTarde());
        dto.setEtiquetas(puntoInteres.getEtiquetas());
        dto.setTelefono(puntoInteres.getTelefono());

        return dto;
    }

 
    public static PuntoInteres toEntity(PuntoInteresDTO dto) {
        PuntoInteres puntoInteres = new PuntoInteres();

      
        puntoInteres.setId(dto.getId());
        puntoInteres.setNombre(dto.getNombre());
        puntoInteres.setDescripcionBreve(dto.getDescripcionBreve());
        puntoInteres.setDescripcionDetallada(dto.getDescripcionDetallada());
        puntoInteres.setLatitud(dto.getLatitud());
        puntoInteres.setLongitud(dto.getLongitud());
        puntoInteres.setCalle(dto.getCalle());
        puntoInteres.setNumero(dto.getNumero());
        puntoInteres.setLocalidad(dto.getLocalidad());
        puntoInteres.setUrl(dto.getUrl());
        puntoInteres.setImagen(dto.getImagen());
        puntoInteres.setHorarioAperturaManana(dto.getHorarioAperturaManana());
        puntoInteres.setHorarioAperturaTarde(dto.getHorarioAperturaTarde());
        puntoInteres.setHorarioCierreManana(dto.getHorarioCierreManana());
        puntoInteres.setHorarioCierreTarde(dto.getHorarioCierreTarde());
        puntoInteres.setEtiquetas(dto.getEtiquetas());
        puntoInteres.setTelefono(dto.getTelefono());

        return puntoInteres;
    }
}