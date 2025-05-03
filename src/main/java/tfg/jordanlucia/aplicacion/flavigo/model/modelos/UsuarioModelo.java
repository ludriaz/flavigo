package tfg.jordanlucia.aplicacion.flavigo.model.modelos;

public class UsuarioModelo {
    
    private Integer  id;
    private String nombre;
    private String email;
    private String contrasena;
    private PuntoDeInteresModelo local;
    private String rol;
    private String fotoPerfil;

    // Constructor vacío
    public UsuarioModelo() {
    }

    // Constructor completo
    public UsuarioModelo(Integer  id, String nombre, String email, String contrasena, PuntoDeInteresModelo local, String rol, String fotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.local = local;
        this.rol = rol;
        this.fotoPerfil = fotoPerfil;
    }

    // Getters y Setters
    public Integer  getId() {
        return id;
    }

    public void setId(Integer  id) {
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public PuntoDeInteresModelo getLocal() {
        return local;
    }

    public void setLocal(PuntoDeInteresModelo local) {
        this.local = local;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", local=" + local +
                ", rol='" + rol + '\'' +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                '}';
    }
}
