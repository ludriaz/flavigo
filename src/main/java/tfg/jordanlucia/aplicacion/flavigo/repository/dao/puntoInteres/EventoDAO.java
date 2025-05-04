package tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres;

import java.util.List;

import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Evento;



public interface EventoDAO {
    Evento guardar(Evento evento);
    Optional<Evento> buscarPorId(Integer id);
    List<Evento> buscarTodos();
    void eliminarPorId(Integer id);
}