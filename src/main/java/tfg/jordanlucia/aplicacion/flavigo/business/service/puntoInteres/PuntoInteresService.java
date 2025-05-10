package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres.ServiceInterface.PuntoInteresServiceInterface;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.puntoIntres.PuntoInteresDTO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.PuntoInteresRepository;
import tfg.jordanlucia.aplicacion.flavigo.web.assembler.puntoInteres.PuntoInteresAssembler;
import tfg.jordanlucia.aplicacion.flavigo.web.model.PuntoInteresFilter;

@Service
public class PuntoInteresService implements PuntoInteresServiceInterface {

	@Autowired
	private PuntoInteresRepository puntoInteresDAO;

	@Override
	@Transactional
	public boolean createPuntoInteres(PuntoInteresDTO dto) {
		Optional<PuntoInteres> existente = puntoInteresDAO.findByNombre(dto.getNombre());
		if (existente.isPresent()) {
			return false;
		}
		PuntoInteres entidad = PuntoInteresAssembler.toEntity(dto);
		puntoInteresDAO.save(entidad);
		return true;
	}

	@Override
	public void deletePuntoInteres(int id) {
		puntoInteresDAO.deleteById(id);
	}

	@Override
	@Transactional
	public boolean edit(PuntoInteresDTO dto) {
		PuntoInteres puntoInteres = puntoInteresDAO.findById(dto.getId())
				.orElseThrow(() -> new RuntimeException("Punto de interés no encontrado"));

		Optional<PuntoInteres> existente = puntoInteresDAO.findByNombre(dto.getNombre());

		 // Use == for comparing integer IDs
        if (existente.isPresent() && existente.get().getId() != dto.getId()) {
            return false;
		}

		// Actualiza los campos del punto de interés
		puntoInteres.setNombre(dto.getNombre());
		puntoInteres.setDescripcionBreve(dto.getDescripcionBreve());
		puntoInteres.setDescripcionDetallada(dto.getDescripcionDetallada());
		puntoInteres.setLatitud(dto.getLatitud());
		puntoInteres.setLongitud(dto.getLongitud());
		puntoInteres.setCalle(dto.getCalle());
		puntoInteres.setNumero(dto.getNumero());
		puntoInteres.setLocalidad(dto.getLocalidad());
		puntoInteres.setUrl(dto.getUrl());
		puntoInteres.setImagen(dto.getImagen());
		puntoInteres.setHorarioAperturaManana(dto.getHorarioAperturaManana());
		puntoInteres.setHorarioAperturaTarde(dto.getHorarioAperturaTarde());
		puntoInteres.setHorarioCierreManana(dto.getHorarioCierreManana());
		puntoInteres.setHorarioCierreTarde(dto.getHorarioCierreTarde());
		puntoInteres.setEtiquetas(dto.getEtiquetas());
		puntoInteres.setTelefono(dto.getTelefono());
		puntoInteresDAO.save(puntoInteres);
		return true;
	}

	@Override
	public PuntoInteresDTO findPuntoInteresDTOById(int id) {
		Optional<PuntoInteres> optional = puntoInteresDAO.findById(id);
		return optional.map(PuntoInteresAssembler::toDTO).orElse(null);
	}

	@Override
	public PuntoInteres findByNombre(String nombre) {
		return puntoInteresDAO.findByNombre(nombre).orElse(null);
	}

	@Override
	public Iterable<PuntoInteres> findALL() {
	System.out.println(puntoInteresDAO.findAll());
		return puntoInteresDAO.findAll();
	}

	@Override
	public Page<PuntoInteresDTO> search(PuntoInteresFilter filtro) {
		Pageable pageable = PageRequest.of(
				filtro.getPage() == null ? filtro.getStart() / filtro.getLength() : filtro.getPage(),
				filtro.getLength());

		Page<PuntoInteres> page = puntoInteresDAO.findByFilter(filtro.getIdPuntoInteres(), 
				filtro.getNombre(),
				filtro.getTipo(), 
				pageable);

		return page.map(PuntoInteresAssembler::toDTO);
	}

	@Override
	public PuntoInteres findById(int id) {
		return puntoInteresDAO.findById(id).orElse(null);
	}
}
