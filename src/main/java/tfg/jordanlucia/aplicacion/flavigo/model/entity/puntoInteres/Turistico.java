package tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoTuristico;




@Entity
@PrimaryKeyJoinColumn(name = "id") 
public class Turistico extends PuntoInteres {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoTuristico tipoTuristico;

    // Getters y setters

    public TipoTuristico getTipoTuristico() {
        return tipoTuristico;
    }

    public void setTipoTuristico(TipoTuristico tipoTuristico) {
        this.tipoTuristico = tipoTuristico;
    }
    
}