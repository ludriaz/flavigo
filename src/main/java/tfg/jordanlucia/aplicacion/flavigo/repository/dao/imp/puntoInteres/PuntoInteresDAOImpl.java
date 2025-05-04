package tfg.jordanlucia.aplicacion.flavigo.repository.dao.imp.puntoInteres;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.PuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres.PuntoInteresDAO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.PuntoInteresRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class PuntoInteresDAOImpl implements PuntoInteresDAO {

    @Autowired
    private PuntoInteresRepository puntoInteresRepository;

    @Override
    public PuntoInteres guardar(PuntoInteres puntoInteres) {
        return puntoInteresRepository.save(puntoInteres);
    }

    @Override
    public Optional<PuntoInteres> buscarPorId(Integer id) {
        return puntoInteresRepository.findById(id);
    }

    @Override
    public List<PuntoInteres> buscarTodos() {
        return puntoInteresRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        puntoInteresRepository.deleteById(id);
    }
}