package tfg.jordanlucia.aplicacion.flavigo.repository.dao.imp.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Alojamiento;
import tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres.AlojamientoDAO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.AlojamientoRepository;



@Repository
public class AlojamientoDAOImpl implements AlojamientoDAO {

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    @Override
    public Alojamiento guardar(Alojamiento alojamiento) {
        return alojamientoRepository.save(alojamiento);
    }

    @Override
    public Optional<Alojamiento> buscarPorId(Integer id) {
        return alojamientoRepository.findById(id);
    }

    @Override
    public List<Alojamiento> buscarTodos() {
        return alojamientoRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        alojamientoRepository.deleteById(id);
    }
}