package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.PuntoInteresRepository;



@Service
public class PuntoInteresService {

    @Autowired
    private PuntoInteresRepository puntoInteresRepository;

    public PuntoInteres guardar(PuntoInteres puntoInteres) {
        return puntoInteresRepository.save(puntoInteres);
    }

    public Optional<PuntoInteres> buscarPorId(Integer id) {
        return puntoInteresRepository.findById(id);
    }

    public List<PuntoInteres> buscarTodos() {
        return puntoInteresRepository.findAll();
    }

    public void eliminarPorId(Integer id) {
        puntoInteresRepository.deleteById(id);
    }
}