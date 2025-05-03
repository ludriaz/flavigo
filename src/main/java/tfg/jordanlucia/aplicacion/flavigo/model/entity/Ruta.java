package tfg.jordanlucia.aplicacion.flavigo.model.entity;

import jakarta.persistence.*;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.Nivel;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.TipoRuta;

@Entity
@Table(name = "TD_RUTA")
@SequenceGenerator(name = "ruta_seq", sequenceName = "ruta_seq", initialValue = 0, allocationSize = 1)
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ruta_seq")
    @Column(name = "id")
    private Integer  id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "duracion_aproximada")
    private String duracionAproximada;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel")
    private Nivel nivel;

    @Column(name = "imagen")
    private String imagen;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_ruta")
    private TipoRuta tipoRuta;

    // Constructor vacío
    public Ruta() {
    }

    // Constructor completo
    public Ruta(Integer  id, String nombre, String descripcion, String duracionAproximada, Nivel nivel, String imagen, TipoRuta tipoRuta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionAproximada = duracionAproximada;
        this.nivel = nivel;
        this.imagen = imagen;
        this.tipoRuta = tipoRuta;
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
        return "Ruta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracionAproximada='" + duracionAproximada + '\'' +
                ", nivel=" + nivel +
                ", imagen='" + imagen + '\'' +
                ", tipoRuta=" + tipoRuta +
                '}';
    }
}