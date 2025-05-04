package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Actividad;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.ActividadRepository;


@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public Actividad guardar(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public Optional<Actividad> buscarPorId(Integer id) {
        return actividadRepository.findById(id);
    }

    public List<Actividad> buscarTodos() {
        return actividadRepository.findAll();
    }

    public void eliminarPorId(Integer id) {
        actividadRepository.deleteById(id);
    }
}