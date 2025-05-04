package tfg.jordanlucia.aplicacion.flavigo.repository.dao.imp.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Evento;
import tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres.EventoDAO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.EventoRepository;



@Repository
public class EventoDAOImpl implements EventoDAO {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Optional<Evento> buscarPorId(Integer id) {
        return eventoRepository.findById(id);
    }

    @Override
    public List<Evento> buscarTodos() {
        return eventoRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        eventoRepository.deleteById(id);
    }
}