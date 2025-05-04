package tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres;

public class ComercioDTO extends PuntoInteresDTO {

    private String tipoComercio;
    private String productosDestacados;
    
	public String getTipoComercio() {
		return tipoComercio;
	}
	public void setTipoComercio(String tipoComercio) {
		this.tipoComercio = tipoComercio;
	}
	public String getProductosDestacados() {
		return productosDestacados;
	}
	public void setProductosDestacados(String productosDestacados) {
		this.productosDestacados = productosDestacados;
	}

  
}