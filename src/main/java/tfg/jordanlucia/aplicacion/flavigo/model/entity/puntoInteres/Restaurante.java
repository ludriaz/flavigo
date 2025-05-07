package tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres;

import jakarta.persistence.Entity;

import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.Ambiente;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.RangoPrecios;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoCocina;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
@Table(name = "TD_RESTAURANTE")
@PrimaryKeyJoinColumn(name = "id") 
public class Restaurante extends PuntoInteres {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoCocina tipoCocina;

    @Column(columnDefinition = "TEXT")
    private String menuDestacado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private RangoPrecios rangoPrecios;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Ambiente ambiente;

    // Getters y Setters

    public TipoCocina getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(TipoCocina tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public String getMenuDestacado() {
        return menuDestacado;
    }

    public void setMenuDestacado(String menuDestacado) {
        this.menuDestacado = menuDestacado;
    }

    public RangoPrecios getRangoPrecios() {
        return rangoPrecios;
    }

    public void setRangoPrecios(RangoPrecios rangoPrecios) {
        this.rangoPrecios = rangoPrecios;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
}