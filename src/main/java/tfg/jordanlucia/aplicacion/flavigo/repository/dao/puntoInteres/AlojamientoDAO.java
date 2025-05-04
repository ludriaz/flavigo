package tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres;

import java.util.List;

import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Alojamiento;




public interface AlojamientoDAO {
    Alojamiento guardar(Alojamiento alojamiento);
    Optional<Alojamiento> buscarPorId(Integer id);
    List<Alojamiento> buscarTodos();
    void eliminarPorId(Integer id);
}