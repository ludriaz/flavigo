package tfg.jordanlucia.aplicacion.flavigo.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Empresa;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.Usuario;

@Repository
public interface EmpresaDAOInterface extends JpaRepository<Empresa, Integer>{

	Optional<Empresa> findByNombre(String username);
	Optional<Empresa> findByEmail(String email);
}
