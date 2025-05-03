package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Usuario;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.UsuarioModelo;
import tfg.jordanlucia.aplicacion.flavigo.repository.UsuarioDAOInterface;
import tfg.jordanlucia.aplicacion.flavigo.web.UsuarioAssembler;

public class UsuarioServiceImpl implements UsuarioServiceInterface {

    @Autowired
    private UsuarioDAOInterface usuarioDAO;

    @Override
    public UsuarioModelo create(UsuarioModelo usuarioModelo) {
        // Convertimos el modelo a la entidad
        Usuario usuario = UsuarioAssembler.toDomain(usuarioModelo);
        // Guardamos la entidad en la base de datos
        Usuario usuarioGuardado = usuarioDAO.save(usuario);
        // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
        return UsuarioAssembler.toView(usuarioGuardado);
    }

    @Override
    public UsuarioModelo save(UsuarioModelo usuarioModelo) {
        // Convertimos el modelo a la entidad
        Usuario usuario = UsuarioAssembler.toDomain(usuarioModelo);
        // Guardamos la entidad en la base de datos (puede ser creación o actualización)
        Usuario usuarioGuardado = usuarioDAO.save(usuario);
        // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
        return UsuarioAssembler.toView(usuarioGuardado);
    }

    @Override
    public void delete(long id) {
        // Buscamos el Usuario por ID
        Optional<Usuario> usuarioOptional = usuarioDAO.findById(id);
        if (usuarioOptional.isPresent()) {
            // Si el Usuario existe, lo eliminamos
            usuarioDAO.delete(usuarioOptional.get());
        } else {
            // Si no existe, podrías lanzar una excepción o manejarlo de otra forma
            throw new RuntimeException("Usuario no encontrado con el ID: " + id);
        }
    }

    @Override
    public UsuarioModelo findById(long id) {
        // Buscamos el Usuario por ID
        Optional<Usuario> usuarioOptional = usuarioDAO.findById(id);
        if (usuarioOptional.isPresent()) {
            // Si el Usuario existe, lo convertimos al modelo y lo retornamos
            return UsuarioAssembler.toView(usuarioOptional.get());
        } else {
            // Si no se encuentra el Usuario, retornamos null o podrías lanzar una excepción
            return null;
        }
    }

    @Override
    public List<UsuarioModelo> findAll() {
        // Obtenemos todos los Usuarios de la base de datos
        List<Usuario> usuarios = (List<Usuario>) usuarioDAO.findAll();
        // Convertimos todas las entidades a modelos
        List<UsuarioModelo> usuarioModelos = usuarios.stream()
                .map(UsuarioAssembler::toView)
                .collect(Collectors.toList());
        return usuarioModelos;
    }

   
}
