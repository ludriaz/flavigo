package tfg.jordanlucia.aplicacion.flavigo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TD_PARADA_PUNTO_INTERES")
@SequenceGenerator(name = "parada_punto_interes_seq", sequenceName = "parada_punto_interes_seq", initialValue = 0, allocationSize = 1)
public class ParadaPuntoInteres {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parada_punto_interes_seq")
    @Column(name = "id")
    private Integer  idParada;

    @Column(name = "id_punto_interes", nullable = false)
    private Integer idPuntoInteres;

    @Column(name = "orden_en_parada", nullable = false)
    private Integer ordenEnParada;

    @Column(name = "notas_adicionales")
    private String notasAdicionales;

    // Constructor vacío
    public ParadaPuntoInteres() {
    }

    // Constructor completo
    public ParadaPuntoInteres(Integer  idParada, Integer idPuntoInteres, Integer ordenEnParada, String notasAdicionales) {
        this.idParada = idParada;
        this.idPuntoInteres = idPuntoInteres;
        this.ordenEnParada = ordenEnParada;
        this.notasAdicionales = notasAdicionales;
    }

    // Getters y Setters

    public Integer getIdParada() {
        return idParada;
    }

    public void setIdParada(Integer  idParada) {
        this.idParada = idParada;
    }

    public Integer getIdPuntoInteres() {
        return idPuntoInteres;
    }

    public void setIdPuntoInteres(Integer idPuntoInteres) {
        this.idPuntoInteres = idPuntoInteres;
    }

    public Integer getOrdenEnParada() {
        return ordenEnParada;
    }

    public void setOrdenEnParada(Integer ordenEnParada) {
        this.ordenEnParada = ordenEnParada;
    }

    public String getNotasAdicionales() {
        return notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }

    @Override
    public String toString() {
        return "ParadaPuntoInteres{" +
                "idParada=" + idParada +
                ", idPuntoInteres=" + idPuntoInteres +
                ", ordenEnParada=" + ordenEnParada +
                ", notasAdicionales='" + notasAdicionales + '\'' +
                '}';
    }
}
