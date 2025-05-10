package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.Usuario;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.UsuarioModelo;
import tfg.jordanlucia.aplicacion.flavigo.repository.UsuarioDAOInterface;
import tfg.jordanlucia.aplicacion.flavigo.web.UsuarioAssembler;
import tfg.jordanlucia.aplicacion.flavigo.web.model.UsuarioFilter;
@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface {

    @Autowired
    private UsuarioDAOInterface usuarioDAO;

    @Override
    public boolean create(UsuarioModelo usuarioModelo) {
        // Convertimos el modelo a la entidad
        Usuario usuario = UsuarioAssembler.toDomain(usuarioModelo);

        // Verificamos si ya existe un usuario con el mismo email
        if (usuarioDAO.existsByEmail(usuario.getEmail())) {
            return false; // No se crea porque ya existe
        }

        // Guardamos la entidad en la base de datos
        usuarioDAO.save(usuario);

        return true;
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
        // Convertimos todas las entidades a modelosr
        List<UsuarioModelo> usuarioModelos = usuarios.stream()
                .map(UsuarioAssembler::toView)
                .collect(Collectors.toList());
        return usuarioModelos;
    }

    @Override
    public Page<UsuarioModelo> search(UsuarioFilter filtro) {
        Pageable pageable = PageRequest.of(
            filtro.getPage() == null ? filtro.getStart() : filtro.getPage(),
            filtro.getLength(),
            filtro.getOrdenacionSort()
        );

        Page<Usuario> page = usuarioDAO.findByFilter(
            filtro.getId(),
           filtro.getEmail(),
           filtro.getNombre(),
            filtro.getRol(),
            pageable
        );

        // Convertimos la página de entidades a modelos
        return page.map(UsuarioAssembler::toView);
    }

	@Override
	public boolean edit(@Valid UsuarioModelo usuarioModelo) {
		// TODO Auto-generated method stub
		return false;
	}

   
}
