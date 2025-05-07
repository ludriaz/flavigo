package tfg.jordanlucia.aplicacion.flavigo.web.model;

import tfg.jordanlucia.aplicacion.flavigo.web.helper.FiltroPaginadoDatatables;

public class PuntoInteresFilter extends FiltroPaginadoDatatables{

    private String nombre;    
    private String tipo;      
    private Integer id;       

   
    public PuntoInteresFilter() {
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

	public void setId(Integer id) {
		this.id = id;
	}
    
   
    
}