package tfg.jordanlucia.aplicacion.flavigo.repository.dao.imp.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Restaurante;
import tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres.RestauranteDAO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.RestauranteRepository;



@Repository
public class RestauranteDAOImpl implements RestauranteDAO {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public Restaurante guardar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Optional<Restaurante> buscarPorId(Integer id) {
        return restauranteRepository.findById(id);
    }

    @Override
    public List<Restaurante> buscarTodos() {
        return restauranteRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        restauranteRepository.deleteById(id);
    }
}