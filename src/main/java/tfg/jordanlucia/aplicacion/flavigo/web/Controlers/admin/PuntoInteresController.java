package tfg.jordanlucia.aplicacion.flavigo.web.Controlers.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // CORRECTO
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/PuntoInteres")
public class PuntoInteresController {

    @GetMapping("/ConsultarPuntoInteres")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String consultarPuntoInteres(Model model) {
        // Lógica para preparar la vista
        return "admin/PuntoInteres/ConsultarPuntoInteres";
    }
}