package tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres;

import java.util.List;

import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Restaurante;



public interface RestauranteDAO {
    Restaurante guardar(Restaurante restaurante);
    Optional<Restaurante> buscarPorId(Integer id);
    List<Restaurante> buscarTodos();
    void eliminarPorId(Integer id);
}