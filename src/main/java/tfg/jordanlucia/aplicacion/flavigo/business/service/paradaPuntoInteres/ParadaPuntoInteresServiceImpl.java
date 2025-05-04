package tfg.jordanlucia.aplicacion.flavigo.business.service.paradaPuntoInteres;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.ParadaPuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaPuntoInteresModelo;
import tfg.jordanlucia.aplicacion.flavigo.repository.ParadaPuntoInteresDAOInterface;
import tfg.jordanlucia.aplicacion.flavigo.web.ParadaPuntoInteresAssembler;

@Service
public class ParadaPuntoInteresServiceImpl implements ParadaPuntoInteresServiceInterface {

    @Autowired
    private ParadaPuntoInteresDAOInterface paradaPuntoInteresDAO;

    @Override
    public ParadaPuntoInteresModelo create(ParadaPuntoInteresModelo modelo) {
        ParadaPuntoInteres entidad = ParadaPuntoInteresAssembler.toDomain(modelo);
        ParadaPuntoInteres guardado = paradaPuntoInteresDAO.save(entidad);
        return ParadaPuntoInteresAssembler.toView(guardado);
    }

    @Override
    public ParadaPuntoInteresModelo save(ParadaPuntoInteresModelo modelo) {
        ParadaPuntoInteres entidad = ParadaPuntoInteresAssembler.toDomain(modelo);
        ParadaPuntoInteres actualizado = paradaPuntoInteresDAO.save(entidad);
        return ParadaPuntoInteresAssembler.toView(actualizado);
    }

    @Override
    public void delete(Integer id) {
        Optional<ParadaPuntoInteres> optional = paradaPuntoInteresDAO.findById(id);
        if (optional.isPresent()) {
            paradaPuntoInteresDAO.delete(optional.get());
        } else {
            throw new RuntimeException("ParadaPuntoInteres no encontrada con ID: " + id);
        }
    }

    @Override
    public ParadaPuntoInteresModelo findById(Integer id) {
        Optional<ParadaPuntoInteres> optional = paradaPuntoInteresDAO.findById(id);
        return optional.map(ParadaPuntoInteresAssembler::toView).orElse(null);
    }

    @Override
    public List<ParadaPuntoInteresModelo> findAll() {
        List<ParadaPuntoInteres> entidades = paradaPuntoInteresDAO.findAll();
        return entidades.stream()
                .map(ParadaPuntoInteresAssembler::toView)
                .collect(Collectors.toList());
    }
}
