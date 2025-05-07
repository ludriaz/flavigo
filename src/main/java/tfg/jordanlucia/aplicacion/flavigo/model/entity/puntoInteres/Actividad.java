package tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres;

import java.math.BigDecimal;



import jakarta.persistence.*;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.Nivel;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoActividad;



@Entity
@Table(name = "TD_ACTIVIDAD")
@PrimaryKeyJoinColumn(name = "id") 
public class Actividad extends PuntoInteres {

		@Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private TipoActividad tipoActividad;  // Enum para el tipo de actividad

	    private Integer duracionAproximada;  // Duración aproximada en minutos, por ejemplo

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private Nivel nivel;  // Enum para el nivel de dificultad

	    private BigDecimal precioEntrada;  // Precio de entrada, utilizando BigDecimal para manejar valores decimales

	    
	    public Actividad() {
			super();
		}
	    
		public Actividad(TipoActividad tipoActividad, Integer duracionAproximada, Nivel nivel,
				BigDecimal precioEntrada) {
			super();
			this.tipoActividad = tipoActividad;
			this.duracionAproximada = duracionAproximada;
			this.nivel = nivel;
			this.precioEntrada = precioEntrada;
		}


		// Getters y setters
	    public TipoActividad getTipoActividad() { return tipoActividad; }
	    public void setTipoActividad(TipoActividad tipoActividad) { this.tipoActividad = tipoActividad; }

	    public Integer getDuracionAproximada() { return duracionAproximada; }
	    public void setDuracionAproximada(Integer duracionAproximada) { this.duracionAproximada = duracionAproximada; }

	    public Nivel getNivel() { return nivel; }
	    public void setNivel(Nivel nivel) { this.nivel = nivel; }

	    public BigDecimal getPrecioEntrada() { return precioEntrada; }
	    public void setPrecioEntrada(BigDecimal precioEntrada) { this.precioEntrada = precioEntrada; }
	    
	    
	}