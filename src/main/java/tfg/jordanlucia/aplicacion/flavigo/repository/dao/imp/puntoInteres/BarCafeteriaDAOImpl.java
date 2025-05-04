package tfg.jordanlucia.aplicacion.flavigo.repository.dao.imp.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.BarCafeteria;
import tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres.BarCafeteriaDAO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.BarCafeteriaRepository;



@Repository
public class BarCafeteriaDAOImpl implements BarCafeteriaDAO {

    @Autowired
    private BarCafeteriaRepository barCafeteriaRepository;

    @Override
    public BarCafeteria guardar(BarCafeteria barCafeteria) {
        return barCafeteriaRepository.save(barCafeteria);
    }

    @Override
    public Optional<BarCafeteria> buscarPorId(Integer id) {
        return barCafeteriaRepository.findById(id);
    }

    @Override
    public List<BarCafeteria> buscarTodos() {
        return barCafeteriaRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        barCafeteriaRepository.deleteById(id);
    }
}