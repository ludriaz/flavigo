package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Turistico;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.TuristicoRepository;


@Service
public class TuristicoService {

    @Autowired
    private TuristicoRepository turisticoRepository;

    public Turistico guardar(Turistico turistico) {
        return turisticoRepository.save(turistico);
    }

    public Optional<Turistico> buscarPorId(Integer id) {
        return turisticoRepository.findById(id);
    }

    public List<Turistico> buscarTodos() {
        return turisticoRepository.findAll();
    }

    public void eliminarPorId(Integer id) {
        turisticoRepository.deleteById(id);
    }
}