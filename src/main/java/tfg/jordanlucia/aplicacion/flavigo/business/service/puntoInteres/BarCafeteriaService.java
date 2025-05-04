package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.BarCafeteria;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.BarCafeteriaRepository;



@Service
public class BarCafeteriaService {

    @Autowired
    private BarCafeteriaRepository barCafeteriaRepository;

    public BarCafeteria guardar(BarCafeteria barCafeteria) {
        return barCafeteriaRepository.save(barCafeteria);
    }

    public Optional<BarCafeteria> buscarPorId(Integer id) {
        return barCafeteriaRepository.findById(id);
    }

    public List<BarCafeteria> buscarTodos() {
        return barCafeteriaRepository.findAll();
    }

    public void eliminarPorId(Integer id) {
        barCafeteriaRepository.deleteById(id);
    }
}