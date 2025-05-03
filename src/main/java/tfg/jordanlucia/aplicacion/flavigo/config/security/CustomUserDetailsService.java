package tfg.jordanlucia.aplicacion.flavigo.config.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.repository.EmpresaDAOInterface;
import tfg.jordanlucia.aplicacion.flavigo.repository.UsuarioDAOInterface;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private  UsuarioDAOInterface usuarioDAO;
	@Autowired
    private  EmpresaDAOInterface empresaDAO;
    

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    return usuarioDAO.findByEmail(email)
	        .map(Usuario -> new User(
	        		Usuario.getEmail(),
	        		Usuario.getContrasena(),
	            List.of(new SimpleGrantedAuthority("ROLE_" + Usuario.getRol()))
	        ))
	        .or(() -> empresaDAO.findByEmail(email)
	            .map(empresa -> new User(
	                empresa.getEmail(),
	                empresa.getContrasena(),
	                List.of(new SimpleGrantedAuthority("ROLE_EMPRESA"))
	            )))
	        .orElseThrow(() -> new UsernameNotFoundException("No se encontró el usuario o empresa con email: " + email));
	}
}