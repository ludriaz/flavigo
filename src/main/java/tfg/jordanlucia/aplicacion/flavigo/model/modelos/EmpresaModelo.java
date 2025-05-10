package tfg.jordanlucia.aplicacion.flavigo.model.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.TipoPlan;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;


public class EmpresaModelo {
	 private Integer  id;
	   private String nombre;
	   private String apellido1;
	   private String apellido2;
	   private String cif;
	   private TipoPlan tipoPlan;
	   private LocalDateTime fechaAlta;
	   private String email;
	   private String telefono;
	   private PuntoInteresDTO puntoDeInteres;
	   
	   
	   
	public EmpresaModelo() {
	}
	
	public EmpresaModelo(Integer  id, String nombre, String apellido1, String apellido2, String cif, TipoPlan tipoPlan,
			LocalDateTime fechaAlta, String email, String telefono, PuntoInteresDTO  puntoDeInteres) {

		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cif = cif;
		this.tipoPlan = tipoPlan;
		this.fechaAlta = fechaAlta;
		this.email = email;
		this.telefono = telefono;
		this.puntoDeInteres = puntoDeInteres;
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
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public TipoPlan getTipoPlan() {
		return tipoPlan;
	}
	public void setTipoPlan(TipoPlan tipoPlan) {
		this.tipoPlan = tipoPlan;
	}
	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public PuntoInteresDTO  getPuntoDeInteres() {
		return puntoDeInteres;
	}
	public void setPuntoDeInteres(PuntoInteresDTO  puntoDeInteres) {
		this.puntoDeInteres = puntoDeInteres;
	}

	@Override
	public String toString() {
		return "EmpresaModelo [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", cif=" + cif + ", tipoPlan=" + tipoPlan + ", fechaAlta=" + fechaAlta + ", email="
				+ email + ", telefono=" + telefono + ", puntoDeInteres=" + puntoDeInteres + "]";
	}
	   
	   
	
	
}
