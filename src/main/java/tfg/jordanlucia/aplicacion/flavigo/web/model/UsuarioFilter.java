package tfg.jordanlucia.aplicacion.flavigo.web.model;

import tfg.jordanlucia.aplicacion.flavigo.web.helper.FiltroPaginadoDatatables;

public class UsuarioFilter extends FiltroPaginadoDatatables{

    private Integer id;
    private String nombre;
    private String email;
    private String rol;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
    
    

  
}
