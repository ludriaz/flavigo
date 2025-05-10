package tfg.jordanlucia.aplicacion.flavigo.web.Controlers.admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import tfg.jordanlucia.aplicacion.flavigo.config.security.SecurityConfig;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;
import tfg.jordanlucia.aplicacion.flavigo.web.helper.JsonPaginationWrapper;

import tfg.jordanlucia.aplicacion.flavigo.web.model.PuntoInteresFilter;
import tfg.jordanlucia.aplicacion.flavigo.web.model.UsuarioFilter;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.TipoPuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres.ServiceInterface.PuntoInteresServiceInterface;


@Controller
@RequestMapping("/admin/PuntoInteres")
public class PuntoInteresController {

    private final SecurityConfig securityConfig;
    
    private static final String CONSULTAR_PUNTO_INTERES = "admin/PuntoInteres/ConsultarPuntoInteres";
    private static final String LISTA_PUNTOS = "listaPuntos";
    private static final String FORMULARIO_EDITAR_PUNTO = "admin/PuntoInteres/editarPuntoInteres";
    private static final String FORMULARIO_NUEVO_PUNTO = "admin/PuntoInteres/formularioNuevoPuntoInteres";

    @Autowired
    private PuntoInteresServiceInterface service;

    PuntoInteresController(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    @GetMapping("/ConsultarPuntoInteres")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getConsultarPuntoInteres(Model model) {
        model.addAttribute(LISTA_PUNTOS, service.findALL());
        return CONSULTAR_PUNTO_INTERES;
    }

    @GetMapping("/ConsultarPuntoInteresJSON")
    public @ResponseBody JsonPaginationWrapper<PuntoInteresDTO> getPuntosInteresJSON(@ModelAttribute PuntoInteresFilter filter) {
        if (filter == null) filter = new PuntoInteresFilter();
        if (filter.getLength() == null) filter.setLength(10);
        if (filter.getPage() == null) filter.setPage(0);
        if (filter.getDraw() == null) filter.setDraw(0);

        Page<PuntoInteresDTO> resultado = service.search(filter);

        return new JsonPaginationWrapper<>(resultado, filter.getDraw());
    }

    @GetMapping("/Editar/{id}")
    public String editarPuntoInteres(@PathVariable("id") int id, Model model) {
        PuntoInteres punto = service.findById(id);
        if (punto == null) {
            return "redirect:/admin/PuntoInteres/ConsultarPuntoInteres";
        }
        model.addAttribute("puntoModel", punto);
        model.addAttribute("tipos", TipoPuntoInteres.values());
        return FORMULARIO_EDITAR_PUNTO;
    }

    @GetMapping("/Nuevo")
    public String mostrarFormularioNuevoPunto(Model model) {
        model.addAttribute("puntoModel", new PuntoInteresDTO());
        model.addAttribute("tipos", TipoPuntoInteres.values());
        return FORMULARIO_NUEVO_PUNTO;
    }

    @PostMapping("/Guardar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String guardarPuntoInteres(@Valid @ModelAttribute("puntoModel") PuntoInteresDTO puntoModel, BindingResult resultadoValidacion, Model model) {
        if (resultadoValidacion.hasErrors()) {
            model.addAttribute("tipos", TipoPuntoInteres.values());
            return FORMULARIO_NUEVO_PUNTO;
        }

        boolean creado = service.createPuntoInteres(puntoModel);

        if (!creado) {
            resultadoValidacion.rejectValue("nombre", null, "Ya existe un punto de interés con ese nombre.");
            model.addAttribute("tipos", TipoPuntoInteres.values());
            return FORMULARIO_NUEVO_PUNTO;
        }

        return "redirect:/admin/PuntoInteres/ConsultarPuntoInteres";
    }

    @PostMapping("/Actualizar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String actualizarPuntoInteres(@Valid @ModelAttribute("puntoModel") PuntoInteresDTO puntoModel, BindingResult resultadoValidacion, Model model) {
        String salida = CONSULTAR_PUNTO_INTERES;

        if (resultadoValidacion.hasErrors()) {
            model.addAttribute("tipos", TipoPuntoInteres.values());
            salida = FORMULARIO_EDITAR_PUNTO;
        } else {
            boolean editado = service.edit(puntoModel);
            if (!editado) {
                resultadoValidacion.rejectValue("nombre", "error.nombre", "Ya existe otro punto de interés con el mismo nombre.");
                model.addAttribute("tipos", TipoPuntoInteres.values());
                salida = FORMULARIO_EDITAR_PUNTO;
            } else {
                model.addAttribute(LISTA_PUNTOS, service.findALL());
            }
        }
        return salida;
    }

    @PostMapping("/Borrar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String borrarPuntoInteres(@PathVariable("id") int id, Model model) {
        service.deletePuntoInteres(id);
        model.addAttribute(LISTA_PUNTOS, service.findALL());
        return CONSULTAR_PUNTO_INTERES;
    }
}