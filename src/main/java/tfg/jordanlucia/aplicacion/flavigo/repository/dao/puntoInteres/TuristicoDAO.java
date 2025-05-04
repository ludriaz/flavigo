package tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres;

import java.util.List;

import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Turistico;



public interface TuristicoDAO {
    Turistico guardar(Turistico turistico);
    Optional<Turistico> buscarPorId(Integer id);
    List<Turistico> buscarTodos();
    void eliminarPorId(Integer id);
}