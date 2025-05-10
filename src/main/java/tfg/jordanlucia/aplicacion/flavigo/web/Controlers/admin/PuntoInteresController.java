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
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.ActividadDTO;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.AlojamientoDTO;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.BarCafeteriaDTO;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.ComercioDTO;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.EventoDTO;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.RestauranteDTO;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.TuristicoDTO;
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

    @GetMapping("/formularioEditarPuntoInteres")
    public String editarPuntoInteres(@RequestParam("id") Integer id, Model model) {
        PuntoInteresDTO punto = service.findById(id);
        if (punto == null) {
            return CONSULTAR_PUNTO_INTERES;
        }
        model.addAttribute("puntoModel", punto);
        model.addAttribute("tipos", TipoPuntoInteres.values());
        return FORMULARIO_EDITAR_PUNTO;
    }

    @GetMapping("/Nuevo")
    public String mostrarFormularioNuevoPunto(Model model) {
        model.addAttribute("puntoModel", new PuntoInteresDTO());
        model.addAttribute("comercioModel", new ComercioDTO());
        model.addAttribute("eventoModel", new EventoDTO());
        model.addAttribute("actividadModel", new ActividadDTO());
        model.addAttribute("barCafeteriaModel", new BarCafeteriaDTO());
        model.addAttribute("restauranteModel", new RestauranteDTO());
        model.addAttribute("alojamientoModel", new AlojamientoDTO());
        model.addAttribute("turisticoModel", new TuristicoDTO());
        model.addAttribute("tipos", TipoPuntoInteres.values());
        return FORMULARIO_NUEVO_PUNTO;
    }

    @PostMapping("/Guardar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String guardarPuntoInteres(@Valid @ModelAttribute("puntoModel") PuntoInteresDTO puntoModel,
                                        BindingResult resultadoValidacionPunto,
                                        @ModelAttribute("comercioModel") ComercioDTO comercioModel,
                                        BindingResult resultadoValidacionComercio,
                                        @ModelAttribute("eventoModel") EventoDTO eventoModel,
                                        BindingResult resultadoValidacionEvento,
                                        @ModelAttribute("actividadModel") ActividadDTO actividadModel,
                                        BindingResult resultadoValidacionActividad,
                                        @ModelAttribute("barCafeteriaModel") BarCafeteriaDTO barCafeteriaModel,
                                        BindingResult resultadoValidacionBarCafeteria,
                                        @ModelAttribute("restauranteModel") RestauranteDTO restauranteModel,
                                        BindingResult resultadoValidacionRestaurante,
                                        @ModelAttribute("alojamientoModel") AlojamientoDTO alojamientoModel,
                                        BindingResult resultadoValidacionAlojamiento,
                                        @ModelAttribute("turisticoModel") TuristicoDTO turisticoModel,
                                        BindingResult resultadoValidacionTuristico,
                                        Model model) {

        if (resultadoValidacionPunto.hasErrors()) {
            model.addAttribute("tipos", TipoPuntoInteres.values());
            return FORMULARIO_NUEVO_PUNTO;
        }

        String tipoSeleccionado = puntoModel.getTipo();
        boolean creado = false;

        if ("Comercio".equals(tipoSeleccionado)) {
            if (!resultadoValidacionComercio.hasErrors()) {
                creado = service.createPuntoInteres(puntoModel, comercioModel);
            } else {
                model.addAttribute("tipos", TipoPuntoInteres.values());
                model.addAttribute("comercioModel", comercioModel);
                return FORMULARIO_NUEVO_PUNTO;
            }
        } else if ("Evento".equals(tipoSeleccionado)) {
            if (!resultadoValidacionEvento.hasErrors()) {
                creado = service.createPuntoInteres(puntoModel, eventoModel);
            } else {
                model.addAttribute("tipos", TipoPuntoInteres.values());
                model.addAttribute("eventoModel", eventoModel);
                return FORMULARIO_NUEVO_PUNTO;
            }
        } else if ("Actividad".equals(tipoSeleccionado)) {
            if (!resultadoValidacionActividad.hasErrors()) {
                creado = service.createPuntoInteres(puntoModel, actividadModel);
            } else {
                model.addAttribute("tipos", TipoPuntoInteres.values());
                model.addAttribute("actividadModel", actividadModel);
                return FORMULARIO_NUEVO_PUNTO;
            }
        } else if ("Bar_Cafeteria".equals(tipoSeleccionado)) {
            if (!resultadoValidacionBarCafeteria.hasErrors()) {
                creado = service.createPuntoInteres(puntoModel, barCafeteriaModel);
            } else {
                model.addAttribute("tipos", TipoPuntoInteres.values());
                model.addAttribute("barCafeteriaModel", barCafeteriaModel);
                return FORMULARIO_NUEVO_PUNTO;
            }
        } else if ("Restaurante".equals(tipoSeleccionado)) {
            if (!resultadoValidacionRestaurante.hasErrors()) {
                creado = service.createPuntoInteres(puntoModel, restauranteModel);
            } else {
                model.addAttribute("tipos", TipoPuntoInteres.values());
                model.addAttribute("restauranteModel", restauranteModel);
                return FORMULARIO_NUEVO_PUNTO;
            }
        } else if ("Alojamiento".equals(tipoSeleccionado)) {
            if (!resultadoValidacionAlojamiento.hasErrors()) {
                creado = service.createPuntoInteres(puntoModel, alojamientoModel);
            } else {
                model.addAttribute("tipos", TipoPuntoInteres.values());
                model.addAttribute("alojamientoModel", alojamientoModel);
                return FORMULARIO_NUEVO_PUNTO;
            }
        } else if ("Turistico".equals(tipoSeleccionado)) {
            if (!resultadoValidacionTuristico.hasErrors()) {
                creado = service.createPuntoInteres(puntoModel, turisticoModel);
            } else {
                model.addAttribute("tipos", TipoPuntoInteres.values());
                model.addAttribute("turisticoModel", turisticoModel);
                return FORMULARIO_NUEVO_PUNTO;
            }
        } else {
            creado = service.createPuntoInteres(puntoModel, null);
        }

        if (!creado) {
            resultadoValidacionPunto.rejectValue("nombre", null, "Ya existe un punto de interés con ese nombre.");
            model.addAttribute("tipos", TipoPuntoInteres.values());
            return FORMULARIO_NUEVO_PUNTO;
        }

        return CONSULTAR_PUNTO_INTERES;
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