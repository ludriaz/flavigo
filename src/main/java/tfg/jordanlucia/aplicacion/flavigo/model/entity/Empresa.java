package tfg.jordanlucia.aplicacion.flavigo.model.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.TipoPlan;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;

@Entity
@Table(name = "TD_EMPRESA")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer  id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido1", nullable = false)
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "contrasena", nullable = false, unique = true)
    private String contrasena;
    
    @Column(name = "cif", nullable = false, unique = true)
    private String cif;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_plan", nullable = false)
    private TipoPlan tipoPlan;

    @Column(name = "fecha_alta", nullable = false, columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime fechaAlta;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "rol", nullable = false)
    private String rol;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_punto_interes")
    private PuntoInteres puntoDeInteres;


    // Constructor vacío
    public Empresa() {
    }

    
    
    public Empresa(String contrasena, String email, String rol) {
		this.contrasena = contrasena;
		this.email = email;
		this.rol = rol;
	}



	// Constructor completo
    public Empresa(Integer  id, String nombre, String apellido1, String apellido2, String cif, TipoPlan tipoPlan, LocalDateTime fechaAlta, String email, String telefono, PuntoInteres puntoDeInteres) {
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

    // Getters y Setters

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

    public PuntoInteres getPuntoDeInteres() {
        return puntoDeInteres;
    }

    public void setPuntoDeInteres(PuntoInteres puntoDeInteres) {
        this.puntoDeInteres = puntoDeInteres;
    }

    
    
    public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", cif='" + cif + '\'' +
                ", tipoPlan=" + tipoPlan +
                ", fechaAlta=" + fechaAlta +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", puntoDeInteres=" + puntoDeInteres +
                '}';
    }
}