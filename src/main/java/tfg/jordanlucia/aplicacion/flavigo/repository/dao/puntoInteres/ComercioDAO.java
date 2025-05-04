package tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres;

import java.util.List;

import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Comercio;



public interface ComercioDAO {
    Comercio guardar(Comercio comercio);
    Optional<Comercio> buscarPorId(Integer id);
    List<Comercio> buscarTodos();
    void eliminarPorId(Integer id);
}