	package tfg.jordanlucia.aplicacion.flavigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
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
	
	@Query(
		    value = "SELECT u FROM Usuario u " +
		            "WHERE (:id IS NULL OR CAST(u.id AS string) LIKE CONCAT('%', :id, '%')) " +
		            "AND (:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))) " +
		            "AND (:nombre IS NULL OR LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
		            "AND (:rol IS NULL OR LOWER(u.rol) LIKE LOWER(CONCAT('%', :rol, '%')))",
		    
		    countQuery = "SELECT COUNT(u) FROM Usuario u " +
		            "WHERE (:id IS NULL OR CAST(u.id AS string) LIKE CONCAT('%', :id, '%')) " +
		            "AND (:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))) " +
		            "AND (:nombre IS NULL OR LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
		            "AND (:rol IS NULL OR LOWER(u.rol) LIKE LOWER(CONCAT('%', :rol, '%')))"
		)
		Page<Usuario> findByFilter(
		    @Param("id") Integer id,
		    @Param("email") String email,
		    @Param("nombre") String nombre,
		    @Param("rol") String rol,
		    Pageable pageable
		);

	boolean existsByEmail(String email);
	 
}
