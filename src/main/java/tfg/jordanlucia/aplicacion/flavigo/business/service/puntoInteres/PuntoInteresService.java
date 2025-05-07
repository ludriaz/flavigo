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
    private PuntoInteresRepository puntoInteresRepository;

    @Override
    @Transactional
    public PuntoInteres guardar(PuntoInteres puntoInteres) {
        return puntoInteresRepository.save(puntoInteres);
    }

    @Override
    public Optional<PuntoInteres> buscarPorId(Integer id) {
        return puntoInteresRepository.findById(id);
    }

    @Override
    public List<PuntoInteres> buscarTodos() {
        return puntoInteresRepository.findAll();
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer id) {
        puntoInteresRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<PuntoInteresDTO> findALL() {
        Iterable<PuntoInteres> beans = puntoInteresRepository.findAll();
        List<PuntoInteresDTO> dtos = StreamSupport.stream(beans.spliterator(), false)
                .map(PuntoInteresAssembler::toDTO)
                .collect(Collectors.toList());

        return dtos;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page<PuntoInteresDTO> search(PuntoInteresFilter filtro) {
        Pageable pageable = PageRequest.of(
        		filtro.getPage() == null ? filtro.getStart() : filtro.getPage(),
        		filtro.getLength(),
        		filtro.getOrdenacionSort()
        		);

      
        Page<PuntoInteresDTO> page = puntoInteresRepository.findAllWithTipo(
            filtro.getId(),
            filtro.getNombre(),
            filtro.getTipo(),
            pageable
        );

    
        return page;
    }
    
    
    
}