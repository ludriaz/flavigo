	package tfg.jordanlucia.aplicacion.flavigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Ruta;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.Usuario;

@Repository
public interface UsuarioDAOInterface  extends PagingAndSortingRepository<Usuario, Integer> {

	Usuario save(Usuario usuario);

	Optional<Usuario> findById(long id);

	void delete(Usuario usuario);

	List<Usuario> findAll();
	
	Optional<Usuario> findByNombre(String nombre);


	
	Optional<Usuario> findByEmail(String email);
	 
}
