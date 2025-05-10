package tfg.jordanlucia.aplicacion.flavigo.web.Controlers.admin;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import tfg.jordanlucia.aplicacion.flavigo.business.service.UsuarioServiceInterface;
import tfg.jordanlucia.aplicacion.flavigo.config.security.SecurityConfig;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.UsuarioModelo;
import tfg.jordanlucia.aplicacion.flavigo.web.helper.JsonPaginationWrapper;
import tfg.jordanlucia.aplicacion.flavigo.web.model.UsuarioFilter;


@Controller
@RequestMapping("/admin/Usuario")
public class UsuariosController {

    private final SecurityConfig securityConfig;

    @Autowired
    private UsuarioServiceInterface service;

    public UsuariosController(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    private static final String CONSULTAR_USUARIO = "admin/Usuarios/ConsultarUsuarios";
    private static final String LISTA_USUARIOS = "listaUsuarios";
    private static final String FORMULARIO_EDITAR_USUARIO = "admin/Usuarios/formularioEditarUsuario";

    @Autowired
    private UsuarioServiceInterface usuarioService;

    @GetMapping("/ConsultarUsuarios")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getUsuarios(Model modelo) {
        modelo.addAttribute(LISTA_USUARIOS, usuarioService.findAll());
        return CONSULTAR_USUARIO;
    }

    @GetMapping("/ConsultarUsuarioJSON")
    public @ResponseBody JsonPaginationWrapper<UsuarioModelo> getUsuariosJSON(@ModelAttribute UsuarioFilter filter) {
        if (filter == null) filter = new UsuarioFilter();
        if (filter.getLength() == null) filter.setLength(10);
        if (filter.getPage() == null) filter.setPage(0);
        if (filter.getDraw() == null) filter.setDraw(0);

        Page<UsuarioModelo> pagina = usuarioService.search(filter);

        return new JsonPaginationWrapper<>(pagina, filter.getDraw());
    }

    @GetMapping("/formularioNuevoUsuario")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String crearNuevoFormulario(Model modelo) {
        modelo.addAttribute(new UsuarioModelo());
        return "admin/Usuarios/formularioNuevoUsuario";
    }

    @PostMapping("/insertarUsuario")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String insertarUsuario(@Valid @ModelAttribute UsuarioModelo usuarioModelo,
                                  BindingResult resultadoValidacion,
                                  Model modelo) {
        if (resultadoValidacion.hasErrors()) {
            return "admin/Usuarios/formularioNuevoUsuario";
        }

        boolean creado = usuarioService.create(usuarioModelo);

        if (!creado) {
            resultadoValidacion.rejectValue("email", null, "Ya existe un usuario con el email proporcionado.");
            return "admin/Usuarios/formularioNuevoUsuario";
        }

        modelo.addAttribute(LISTA_USUARIOS, usuarioService.findAll());
        return CONSULTAR_USUARIO;
    }

    @PostMapping("/salvarUsuario")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String salvarUsuario(@Valid @ModelAttribute UsuarioModelo usuarioModelo,
                                BindingResult resultadoValidacion,
                                Model modelo) {
        String salida = CONSULTAR_USUARIO;

        if (resultadoValidacion.hasErrors()) {
            salida = "admin/Usuarios/formularioEditarUsuario";
        } else {
            boolean editado = usuarioService.edit(usuarioModelo);
            if (!editado) {
                resultadoValidacion.rejectValue("email", "error.email", "Ya existe un usuario con el mismo email.");
                salida = "admin/Usuarios/formularioEditarUsuario";
            } else {
                modelo.addAttribute(LISTA_USUARIOS, usuarioService.findAll());
            }
        }

        return salida;
    }

    @GetMapping("/formularioEditarUsuario")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editarUsuario(@RequestParam("id") int id, Model modelo) {
        UsuarioModelo usuarioModelo = usuarioService.findById(id);
        modelo.addAttribute("usuarioModelo", usuarioModelo);
        return FORMULARIO_EDITAR_USUARIO;
    }

    @PostMapping("/borrarUsuario")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Map<String, Object> borrarUsuario(@RequestParam("id") int id) {
        Map<String, Object> respuesta = new HashMap<>();
        try {
            usuarioService.delete(id);
            respuesta.put("success", true);
        } catch (Exception e) {
            respuesta.put("success", false);
            respuesta.put("message", "Error al eliminar el usuario: " + e.getMessage());
        }
        return respuesta;
    }
}