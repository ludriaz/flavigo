package tfg.jordanlucia.aplicacion.flavigo.model.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "TD_USUARIO")
@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", initialValue = 0, allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @Column(name = "id")
    private Integer  id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name="local", nullable=false)
    private boolean local;
   
    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    // Constructor vacío
    public Usuario() {
    }
    
    

    public Usuario(String email, String contrasena, String rol) {
		this.email = email;
		this.contrasena = contrasena;
		this.rol = rol;
	}



	// Constructor completo
    public Usuario(Integer  id, String nombre, String email, String contrasena, boolean local, String rol, String fotoPerfil) {
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

    public boolean getLocal() {
        return local;
    }

    public void setLocal(boolean local) {
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
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", local=" + local +
                ", rol=" + rol +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                '}';
    }
}