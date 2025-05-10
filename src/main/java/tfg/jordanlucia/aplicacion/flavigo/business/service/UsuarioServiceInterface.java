package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import jakarta.validation.Valid;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.Usuario;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.UsuarioModelo;
import tfg.jordanlucia.aplicacion.flavigo.web.model.UsuarioFilter;

public interface UsuarioServiceInterface {

    // Crear un nuevo Usuario
    public boolean create(UsuarioModelo usuario);

    // Actualizar un Usuario existente
    public UsuarioModelo save(UsuarioModelo usuario);

    // Eliminar un Usuario por ID
    public void delete(long id);

    // Buscar un Usuario por ID
    public UsuarioModelo findById(long id);

    // Obtener todos los Usuarios
    public List<UsuarioModelo> findAll();
    
    public Page<UsuarioModelo> search(UsuarioFilter filter);

	public boolean edit(@Valid UsuarioModelo usuarioModelo);
    
    
}
