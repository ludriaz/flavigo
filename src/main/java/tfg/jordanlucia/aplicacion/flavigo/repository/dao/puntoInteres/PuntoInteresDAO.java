package tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres;

import java.util.List;

import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;



public interface PuntoInteresDAO {
    PuntoInteres guardar(PuntoInteres puntoInteres);
    Optional<PuntoInteres> buscarPorId(Integer id);
    List<PuntoInteres> buscarTodos();
    void eliminarPorId(Integer id);
}