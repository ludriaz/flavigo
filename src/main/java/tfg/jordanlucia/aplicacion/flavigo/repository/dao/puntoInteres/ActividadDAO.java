package tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres;

import java.util.List;

import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Actividad;



public interface ActividadDAO {
    Actividad guardar(Actividad actividad);
    Optional<Actividad> buscarPorId(Integer id);
    List<Actividad> buscarTodos();
    void eliminarPorId(Integer id);
}