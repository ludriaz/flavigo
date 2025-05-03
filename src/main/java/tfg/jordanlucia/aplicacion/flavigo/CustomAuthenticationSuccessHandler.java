package tfg.jordanlucia.aplicacion.flavigo;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component // Importante para que Spring lo reconozca como un bean
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    // Estrategia para manejar la redirección
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // Determina la URL de destino basada en los roles del usuario
        String targetUrl = determineTargetUrl(authentication);

        // Si la respuesta ya ha sido enviada, no se puede redirigir
        if (response.isCommitted()) {
            // Puedes añadir un log aquí si quieres
            // logger.debug("Cannot redirect to " + targetUrl + " as the response has already been committed");
            return;
        }

        // Realiza la redirección
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    /**
     * Lógica para determinar la URL de redirección basada en los roles.
     */
    protected String determineTargetUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Itera sobre los roles del usuario autenticado
        for (GrantedAuthority grantedAuthority : authorities) {
            String authority = grantedAuthority.getAuthority(); // Obtiene el rol (ej: ROLE_ADMIN)

            // Comprueba los roles y devuelve la URL correspondiente
            if (authority.equals("ROLE_ADMIN")) {
                return "/admin"; // Redirige al admin a /admin
            } else if (authority.equals("ROLE_EMPRESA")) {
                return "/empresa"; // Redirige a la empresa a /empresa
            } else if (authority.equals("ROLE_USER")) {
                 return "/usuario"; // Redirige al usuario normal a /usuario
            }
            // Puedes añadir más roles si los tienes
        }

        // URL por defecto si ninguno de los roles anteriores coincide
        return "/index"; // Por ejemplo, redirigir a la página de inicio general
    }
}