package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Usuario;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.UsuarioModelo;

public interface UsuarioServiceInterface {

    // Crear un nuevo Usuario
    public UsuarioModelo create(UsuarioModelo usuario);

    // Actualizar un Usuario existente
    public UsuarioModelo save(UsuarioModelo usuario);

    // Eliminar un Usuario por ID
    public void delete(long id);

    // Buscar un Usuario por ID
    public UsuarioModelo findById(long id);

    // Obtener todos los Usuarios
    public List<UsuarioModelo> findAll();
    
    
}
