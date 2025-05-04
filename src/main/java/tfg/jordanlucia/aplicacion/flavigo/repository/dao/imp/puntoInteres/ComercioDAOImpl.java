package tfg.jordanlucia.aplicacion.flavigo.repository.dao.imp.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Comercio;
import tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres.ComercioDAO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.ComercioRepository;


@Repository
public class ComercioDAOImpl implements ComercioDAO {

    @Autowired
    private ComercioRepository comercioRepository;

    @Override
    public Comercio guardar(Comercio comercio) {
        return comercioRepository.save(comercio);
    }

    @Override
    public Optional<Comercio> buscarPorId(Integer id) {
        return comercioRepository.findById(id);
    }

    @Override
    public List<Comercio> buscarTodos() {
        return comercioRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        comercioRepository.deleteById(id);
    }
}