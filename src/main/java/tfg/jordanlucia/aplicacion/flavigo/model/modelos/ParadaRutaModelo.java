package tfg.jordanlucia.aplicacion.flavigo.model.modelos;



public class ParadaRutaModelo {

	private Integer  id;
	private RutaModelo ruta;
	private ParadaModelo parada;
	
	
	
	public ParadaRutaModelo() {
	}
	
	public ParadaRutaModelo(Integer  id, RutaModelo ruta, ParadaModelo parada) {
		this.id = id;
		this.ruta = ruta;
		this.parada = parada;
	}
	public Integer  getId() {
		return id;
	}
	public void setId(Integer  id) {
		this.id = id;
	}
	public RutaModelo getRuta() {
		return ruta;
	}
	public void setRuta(RutaModelo ruta) {
		this.ruta = ruta;
	}
	public ParadaModelo getParada() {
		return parada;
	}
	public void setParada(ParadaModelo parada) {
		this.parada = parada;
	}
	
	@Override
	public String toString() {
		return "ParadaRutaModelo [id=" + id + ", ruta=" + ruta + ", parada=" + parada + "]";
	}
	
	

}
