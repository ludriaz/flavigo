package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Alojamiento;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.AlojamientoRepository;

@Service
public class AlojamientoService {

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    public Alojamiento guardar(Alojamiento alojamiento) {
        return alojamientoRepository.save(alojamiento);
    }

    public Optional<Alojamiento> buscarPorId(Integer id) {
        return alojamientoRepository.findById(id);
    }

    public List<Alojamiento> buscarTodos() {
        return alojamientoRepository.findAll();
    }

    public void eliminarPorId(Integer id) {
        alojamientoRepository.deleteById(id);
    }
}