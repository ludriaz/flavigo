package tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres;

import jakarta.persistence.*;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoAlojamiento;




@Entity
@PrimaryKeyJoinColumn(name = "id") 
public class Alojamiento extends PuntoInteres {

    @Column(columnDefinition = "TEXT")
    private String servicios;

    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAlojamiento tipoAlojamiento;  

  
    public Alojamiento() {
        super(); 
    }

    
    public Alojamiento(String servicios, TipoAlojamiento tipoAlojamiento) {
        super(); 
        this.servicios = servicios;
        this.tipoAlojamiento = tipoAlojamiento;
    }

   
    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public TipoAlojamiento getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(TipoAlojamiento tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }
}