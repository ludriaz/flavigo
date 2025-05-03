package tfg.jordanlucia.aplicacion.flavigo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TD_Parada")
@SequenceGenerator(name = "parada_seq", sequenceName = "parada_seq", initialValue = 0, allocationSize = 1)
public class Parada {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parada_seq")
    @Column(name = "id")
    private Integer  id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcionBreve")
    private String descripcionBreve;

    // Constructor vacío
    public Parada() {
    }

    // Constructor completo
    public Parada(Integer  id, String nombre, String descripcionBreve) {
        this.id = id;
        this.nombre = nombre;
        this.descripcionBreve = descripcionBreve;
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

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    @Override
    public String toString() {
        return "Parada{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcionBreve='" + descripcionBreve + '\'' +
                '}';
    }
}