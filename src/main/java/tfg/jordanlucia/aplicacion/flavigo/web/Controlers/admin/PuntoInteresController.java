package tfg.jordanlucia.aplicacion.flavigo.web.Controlers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tfg.jordanlucia.aplicacion.flavigo.config.security.SecurityConfig;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.web.helper.JsonPaginationWrapper;
import tfg.jordanlucia.aplicacion.flavigo.web.model.PuntoInteresFilter;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoPuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres.PuntoInteresService;
import tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres.ServiceInterface.PuntoInteresServiceInterface;


@Controller
@RequestMapping("/admin/PuntoInteres")
public class PuntoInteresController {

    private final SecurityConfig securityConfig;

    private static final String LISTA_PUNTOS = "listaPuntos";

    @Autowired
    private PuntoInteresServiceInterface service;

    PuntoInteresController(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    @GetMapping("/ConsultarPuntoInteres")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getConsultarPuntoInteres(Model model) {
        model.addAttribute(LISTA_PUNTOS, service.findALL());
        return "admin/PuntoInteres/ConsultarPuntoInteres";
    }

    @GetMapping("/ConsultarPuntoInteresJSON")
    public @ResponseBody JsonPaginationWrapper<PuntoInteres> getPuntosInteresJSON(
    		@RequestParam("draw") int draw, @RequestParam("start") int start, @RequestParam("length") int length,
    		@RequestParam("nombre") String nombre, @RequestParam("tipo") String tipo, @RequestParam(name = "idPuntoInteres", required = false) Integer id) {
    	final PuntoInteresFilter filter= new PuntoInteresFilter();
    	
    	filter.setIdPuntoInteres(id);
    	filter.setNombre("".equalsIgnoreCase(nombre)?null:nombre);
    	filter.setTipo("".equalsIgnoreCase(tipo)?null:tipo);
    	filter.setDraw(draw);
    	filter.setPage(start / length);
    	filter.setLength(length);
    	
    	
        Page<PuntoInteres> resultado = service.search(filter);
        
        return new JsonPaginationWrapper<>(resultado, filter.getDraw());
    }
    
    @GetMapping("/Editar/{id}")
    public String editarPuntoInteres(@PathVariable("id") int id, Model model) {
        PuntoInteres punto = service.findById(id); // Usa tu servicio
        if (punto == null) {
            return "redirect:/admin/PuntoInteres"; // Redirige si no se encuentra
        }
        model.addAttribute("punto", punto);
        return "admin/PuntoInteres/editarPuntoInteres"; // Nombre del archivo .html o .jsp
    }
    
    @GetMapping("/Nuevo")
    public String mostrarFormularioNuevoPunto(Model model) {
        model.addAttribute("punto", new PuntoInteres()); // Pasar un objeto vacío para el formulario
        model.addAttribute("tipos", TipoPuntoInteres.values()); // Pasar los valores del enum para el select
        return "admin/PuntoInteres/formularioNuevoPuntoInteres"; // Nombre del archivo HTML para el formulario de creación
    }
    
    
    
}
    
    
