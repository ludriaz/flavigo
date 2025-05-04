package tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres;

import java.util.List;

import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.BarCafeteria;



public interface BarCafeteriaDAO {
    BarCafeteria guardar(BarCafeteria barCafeteria);
    Optional<BarCafeteria> buscarPorId(Integer id);
    List<BarCafeteria> buscarTodos();
    void eliminarPorId(Integer id);
}