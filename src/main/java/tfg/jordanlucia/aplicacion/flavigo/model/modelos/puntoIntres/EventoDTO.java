package tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres;


import java.time.LocalDateTime;

import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoEvento;




public class EventoDTO extends PuntoInteresDTO {

	    private TipoEvento tipoEvento;
	    private LocalDateTime fechaInicio;
	    private LocalDateTime fechaFin;
	    private String nombreOrganizador;
	    
		public TipoEvento getTipoEvento() {
			return tipoEvento;
		}
		public void setTipoEvento(TipoEvento tipoEvento) {
			this.tipoEvento = tipoEvento;
		}
		public LocalDateTime getFechaInicio() {
			return fechaInicio;
		}
		public void setFechaInicio(LocalDateTime fechaInicio) {
			this.fechaInicio = fechaInicio;
		}
		public LocalDateTime getFechaFin() {
			return fechaFin;
		}
		public void setFechaFin(LocalDateTime fechaFin) {
			this.fechaFin = fechaFin;
		}
		public String getNombreOrganizador() {
			return nombreOrganizador;
		}
		public void setNombreOrganizador(String nombreOrganizador) {
			this.nombreOrganizador = nombreOrganizador;
		}

	   
	}