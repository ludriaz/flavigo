package tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres;

public class AlojamientoDTO extends PuntoInteresDTO {

    private String servicios;
    private String tipoAlojamiento;
	public String getServicios() {
		return servicios;
	}
	
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	
	public String getTipoAlojamiento() {
		return tipoAlojamiento;
	}
	
	public void setTipoAlojamiento(String tipoAlojamiento) {
		this.tipoAlojamiento = tipoAlojamiento;
	}

    
}