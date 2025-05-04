package tfg.jordanlucia.aplicacion.flavigo.web.Controlers;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PanelController {

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminPanel(Model model) {
        model.addAttribute("mensaje", "Bienvenido al panel de administrador");
        return "admin/panel"; // Asegúrate de tener un panel.html
    }

    @GetMapping("/empresa")
    public String empresaPanel(Model model) {
        model.addAttribute("mensaje", "Bienvenido al panel de empresa");
        return "panel";
    }

    @GetMapping("/usuario")
    public String usuarioPanel(Model model) {
        model.addAttribute("mensaje", "Bienvenido al panel de usuario");
        return "panel";
    }

    @GetMapping("/index")
    public String index() {
        // No pongas aquí código que cifre o use PasswordEncoder
        return "index"; // Devuelve el nombre de tu vista index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}