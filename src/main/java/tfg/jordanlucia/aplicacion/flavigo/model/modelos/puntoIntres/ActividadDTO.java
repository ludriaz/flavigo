package tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres;

import java.math.BigDecimal;

public class ActividadDTO extends PuntoInteresDTO {

    private String tipoActividad;
    private Integer duracionAproximada;
    private String nivel;
    private BigDecimal precioEntrada;
    
    
	public String getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	public Integer getDuracionAproximada() {
		return duracionAproximada;
	}
	public void setDuracionAproximada(Integer duracionAproximada) {
		this.duracionAproximada = duracionAproximada;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public BigDecimal getPrecioEntrada() {
		return precioEntrada;
	}
	public void setPrecioEntrada(BigDecimal precioEntrada) {
		this.precioEntrada = precioEntrada;
	}

    
}