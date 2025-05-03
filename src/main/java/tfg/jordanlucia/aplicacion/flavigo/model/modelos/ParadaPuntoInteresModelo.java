package tfg.jordanlucia.aplicacion.flavigo.model.modelos;

public class ParadaPuntoInteresModelo {
	private Integer  idParada;
	private Integer  idPuntoInteres;
	private Integer  ordenEnParada;
	private String notasAdicionales;
	
	public ParadaPuntoInteresModelo() {
	}
	
	public ParadaPuntoInteresModelo(Integer  idParada, Integer  idPuntoInteres, Integer  ordenEnParada, String notasAdicionales) {
		this.idParada = idParada;
		this.idPuntoInteres = idPuntoInteres;
		this.ordenEnParada = ordenEnParada;
		this.notasAdicionales = notasAdicionales;
	}
	
	public Integer  getIdParada() {
		return idParada;
	}
	public void setIdParada(Integer  idParada) {
		this.idParada = idParada;
	}
	public Integer  getIdPuntoInteres() {
		return idPuntoInteres;
	}
	public void setIdPuntoInteres(Integer  idPuntoInteres) {
		this.idPuntoInteres = idPuntoInteres;
	}
	public int getOrdenEnParada() {
		return ordenEnParada;
	}
	public void setOrdenEnParada(int ordenEnParada) {
		this.ordenEnParada = ordenEnParada;
	}
	public String getNotasAdicionales() {
		return notasAdicionales;
	}
	public void setNotasAdicionales(String notasAdicionales) {
		this.notasAdicionales = notasAdicionales;
	}
	
}
