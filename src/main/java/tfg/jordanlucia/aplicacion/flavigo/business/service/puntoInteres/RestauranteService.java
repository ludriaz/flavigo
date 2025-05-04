package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Restaurante;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.RestauranteRepository;



@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante guardar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Optional<Restaurante> buscarPorId(Integer id) {
        return restauranteRepository.findById(id);
    }

    public List<Restaurante> buscarTodos() {
        return restauranteRepository.findAll();
    }

    public void eliminarPorId(Integer id) {
        restauranteRepository.deleteById(id);
    }
}