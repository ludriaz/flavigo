package tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoPuntoInteres;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@Table(name = "TD_PUNTO_INTERES")
public class PuntoInteres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion_breve", columnDefinition = "TEXT")
    private String descripcionBreve;

    @Column(name = "descripcion_detallada", columnDefinition = "TEXT")
    private String descripcionDetallada;

    @Digits(integer = 3, fraction = 7)
    @Column(name = "latitud", precision = 10, scale = 7)
    private BigDecimal latitud;

    @Digits(integer = 3, fraction = 7)
    @Column(name = "longitud", precision = 10, scale = 7)
    private BigDecimal longitud;

    @Size(max = 100)
    @Column(name = "calle", length = 100)
    private String calle;

    @Size(max = 10)
    @Column(name = "numero", length = 10)
    private String numero;

    @Size(max = 100)
    @Column(name = "localidad", length = 100)
    private String localidad;

    @Size(max = 255)
    @Column(name = "url", length = 255)
    private String url;

    @Size(max = 255)
    @Column(name = "imagen", length = 255)
    private String imagen;

    @Column(name = "horario_apertura_manana")
    private LocalTime horarioAperturaManana;

    @Column(name = "horario_apertura_tarde")
    private LocalTime horarioAperturaTarde;

    @Column(name = "horario_cierre_manana")
    private LocalTime horarioCierreManana;

    @Column(name = "horario_cierre_tarde")
    private LocalTime horarioCierreTarde;

    @Column(name = "etiquetas", columnDefinition = "TEXT")
    private String etiquetas;

    @Size(max = 20)
    @Column(name = "telefono", length = 20)
    private String telefono;
    
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoPuntoInteres tipo;
    

	public TipoPuntoInteres getTipo() {
		return tipo;
	}

	public void setTipo(TipoPuntoInteres tipo) {
		this.tipo = tipo;
	}

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
	
	

	public PuntoInteres() {
		super();
	}

	public PuntoInteres(int id, @NotNull @Size(max = 100) String nombre, String descripcionBreve,
			String descripcionDetallada, @Digits(integer = 3, fraction = 7) BigDecimal latitud,
			@Digits(integer = 3, fraction = 7) BigDecimal longitud, @Size(max = 100) String calle,
			@Size(max = 10) String numero, @Size(max = 100) String localidad, @Size(max = 255) String url,
			@Size(max = 255) String imagen, LocalTime horarioAperturaManana, LocalTime horarioAperturaTarde,
			LocalTime horarioCierreManana, LocalTime horarioCierreTarde, String etiquetas,
			@Size(max = 20) String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcionBreve = descripcionBreve;
		this.descripcionDetallada = descripcionDetallada;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.url = url;
		this.imagen = imagen;
		this.horarioAperturaManana = horarioAperturaManana;
		this.horarioAperturaTarde = horarioAperturaTarde;
		this.horarioCierreManana = horarioCierreManana;
		this.horarioCierreTarde = horarioCierreTarde;
		this.etiquetas = etiquetas;
		this.telefono = telefono;
	}

   
}