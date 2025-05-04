package tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres;

public class RestauranteDTO extends PuntoInteresDTO {

    private String tipoCocina;
    private String menuDestacado;
    private String rangoPrecios;
    private String ambiente;
    
	public String getTipoCocina() {
		return tipoCocina;
	}
	public void setTipoCocina(String tipoCocina) {
		this.tipoCocina = tipoCocina;
	}
	public String getMenuDestacado() {
		return menuDestacado;
	}
	public void setMenuDestacado(String menuDestacado) {
		this.menuDestacado = menuDestacado;
	}
	public String getRangoPrecios() {
		return rangoPrecios;
	}
	public void setRangoPrecios(String rangoPrecios) {
		this.rangoPrecios = rangoPrecios;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

   
}