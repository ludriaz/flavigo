package tfg.jordanlucia.aplicacion.flavigo.model.modelos;

public class ParadaModelo {

	   private Integer  id;
	   private String nombre;
	   private String descripcionBreve;
	   
	   
	   
	public ParadaModelo() {
	}

	public ParadaModelo(Integer  id, String nombre, String descripcionBreve) {
		this.id = id;
		this.nombre = nombre;
		this.descripcionBreve = descripcionBreve;
	}
	
	public Integer  getId() {
		return id;
	}
	public void setId(Integer  id) {
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

	@Override
	public String toString() {
		return "ParadaModelo [id=" + id + ", nombre=" + nombre + ", descripcionBreve=" + descripcionBreve + "]";
	}
	   
	
	   
}
