package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Evento;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.EventoRepository;


@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Evento> buscarPorId(Integer id) {
        return eventoRepository.findById(id);
    }

    public List<Evento> buscarTodos() {
        return eventoRepository.findAll();
    }

    public void eliminarPorId(Integer id) {
        eventoRepository.deleteById(id);
    }
}