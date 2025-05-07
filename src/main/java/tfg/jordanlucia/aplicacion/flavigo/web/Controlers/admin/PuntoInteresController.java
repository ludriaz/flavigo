package tfg.jordanlucia.aplicacion.flavigo.web.Controlers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;
import tfg.jordanlucia.aplicacion.flavigo.web.helper.JsonPaginationWrapper;
import tfg.jordanlucia.aplicacion.flavigo.web.model.PuntoInteresFilter;
import tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres.PuntoInteresService;


import java.util.List;

@Controller
@RequestMapping("/admin/PuntoInteres")
public class PuntoInteresController {

    private static final String LISTA_PUNTOS = "listaPuntos";

    @Autowired
    private PuntoInteresService service;

    @GetMapping("/ConsultarPuntoInteres")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getConsultarPuntoInteres(Model model) {
        model.addAttribute(LISTA_PUNTOS, service.findALL());
        return "admin/PuntoInteres/ConsultarPuntoInteres";
    }

    @GetMapping("/ConsultarPuntoInteresJSON")
    public @ResponseBody JsonPaginationWrapper<PuntoInteresDTO> getPuntosInteresJSON(@ModelAttribute PuntoInteresFilter filter) {
    	
    	if(filter == null) {
    		filter = new PuntoInteresFilter();
    	}
    	
    	if(filter.getLength() == null) {
    		filter.setLength(10);
    	}
    	
    	if(filter.getPage() == null) {
    		filter.setPage(0);
    	}
    	
    	if(filter.getDraw() == null) {
    		filter.setDraw(0);
    		
    	}
    	
        Page<PuntoInteresDTO> resultado = service.search(filter);
        return new JsonPaginationWrapper<>(resultado, filter.getDraw());
    }
}
    
    
