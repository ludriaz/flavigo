package tfg.jordanlucia.aplicacion.flavigo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parada_ruta")
@SequenceGenerator(name = "parada_ruta_seq", sequenceName = "parada_ruta_seq", initialValue = 0, allocationSize = 1)
public class ParadaRuta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parada_ruta_seq")
    @Column(name = "id")
    private Integer  id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ruta", nullable = false)
    private Ruta ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parada", nullable = false)
    private Parada parada;

    @Column(name = "descripcionBreve")
    private String descripcionBreve;

    // Constructor vacío
    public ParadaRuta() {
    }

    // Constructor completo
    public ParadaRuta(Integer  id, Ruta ruta, Parada parada, String descripcionBreve) {
        this.id = id;
        this.ruta = ruta;
        this.parada = parada;
        this.descripcionBreve = descripcionBreve;
    }

    // Getters y Setters

    public Integer  getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    @Override
    public String toString() {
        return "ParadaRuta{" +
                "id=" + id +
                ", ruta=" + ruta +
                ", parada=" + parada +
                ", descripcionBreve='" + descripcionBreve + '\'' +
                '}';
    }
}