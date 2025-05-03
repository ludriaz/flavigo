package tfg.jordanlucia.aplicacion.flavigo.model.modelos;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.Nivel;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.TipoRuta;

public class RutaModelo {
	 private Integer  id;
	 private String nombre;
	 private String descripcion;
	 private String duracionAproximada;
	 private Nivel nivel;
	 private String imagen;
	 private TipoRuta tipoRuta;
	 
	 
	 
	public RutaModelo() {
	}
	
	public RutaModelo(Integer  id, String nombre, String descripcion, String duracionAproximada, Nivel nivel, String imagen,
			TipoRuta tipoRuta) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionAproximada = duracionAproximada;
		this.nivel = nivel;
		this.imagen = imagen;
		this.tipoRuta = tipoRuta;
	}
	public Integer  getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDuracionAproximada() {
		return duracionAproximada;
	}
	public void setDuracionAproximada(String duracionAproximada) {
		this.duracionAproximada = duracionAproximada;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public TipoRuta getTipoRuta() {
		return tipoRuta;
	}
	public void setTipoRuta(TipoRuta tipoRuta) {
		this.tipoRuta = tipoRuta;
	}

	@Override
	public String toString() {
		return "RutaModelo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", duracionAproximada="
				+ duracionAproximada + ", nivel=" + nivel + ", imagen=" + imagen + ", tipoRuta=" + tipoRuta + "]";
	}
	 
	
	 
}
