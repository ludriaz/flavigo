package tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.Ambiente;


@Entity
@PrimaryKeyJoinColumn(name = "id") // Se conecta al id heredado de PuntoInteres
public class BarCafeteria extends PuntoInteres {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Ambiente ambiente;

    @Column(columnDefinition = "TEXT")
    private String especialidades;

    // Getters y setters

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }
}