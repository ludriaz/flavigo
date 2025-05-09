package tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres;

import java.math.BigDecimal;
import java.time.LocalTime;

public class PuntoInteresDTO {

    private int id;
    private String nombre;
    private String descripcionBreve;
    private String descripcionDetallada;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String calle;
    private String numero;
    private String localidad;
    private String url;
    private String imagen;
    private LocalTime horarioAperturaManana;
    private LocalTime horarioAperturaTarde;
    private LocalTime horarioCierreManana;
    private LocalTime horarioCierreTarde;
    private String etiquetas;
    private String telefono;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcionBreve() {
		return descripcionBreve;
	}
	public void setDescripcionBreve(String descripcionBreve) {
		this.descripcionBreve = descripcionBreve;
	}
	public String getDescripcionDetallada() {
		return descripcionDetallada;
	}
	public void setDescripcionDetallada(String descripcionDetallada) {
		this.descripcionDetallada = descripcionDetallada;
	}
	public BigDecimal getLatitud() {
		return latitud;
	}
	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}
	public BigDecimal getLongitud() {
		return longitud;
	}
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public LocalTime getHorarioAperturaManana() {
		return horarioAperturaManana;
	}
	public void setHorarioAperturaManana(LocalTime horarioAperturaManana) {
		this.horarioAperturaManana = horarioAperturaManana;
	}
	public LocalTime getHorarioAperturaTarde() {
		return horarioAperturaTarde;
	}
	public void setHorarioAperturaTarde(LocalTime horarioAperturaTarde) {
		this.horarioAperturaTarde = horarioAperturaTarde;
	}
	public LocalTime getHorarioCierreManana() {
		return horarioCierreManana;
	}
	public void setHorarioCierreManana(LocalTime horarioCierreManana) {
		this.horarioCierreManana = horarioCierreManana;
	}
	public LocalTime getHorarioCierreTarde() {
		return horarioCierreTarde;
	}
	public void setHorarioCierreTarde(LocalTime horarioCierreTarde) {
		this.horarioCierreTarde = horarioCierreTarde;
	}
	public String getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

    
}