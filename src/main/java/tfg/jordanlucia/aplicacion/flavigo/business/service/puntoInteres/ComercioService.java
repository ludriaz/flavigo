package tfg.jordanlucia.aplicacion.flavigo.business.service.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Comercio;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.ComercioRepository;


@Service
public class ComercioService {

    @Autowired
    private ComercioRepository comercioRepository;

    public Comercio guardar(Comercio comercio) {
        return comercioRepository.save(comercio);
    }

    public Optional<Comercio> buscarPorId(Integer id) {
        return comercioRepository.findById(id);
    }

    public List<Comercio> buscarTodos() {
        return comercioRepository.findAll();
    }

    public void eliminarPorId(Integer id) {
        comercioRepository.deleteById(id);
    }
}