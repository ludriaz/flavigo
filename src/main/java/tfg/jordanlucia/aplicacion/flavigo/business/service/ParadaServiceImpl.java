package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Parada;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaModelo;
import tfg.jordanlucia.aplicacion.flavigo.repository.ParadaDAOInterface;
import tfg.jordanlucia.aplicacion.flavigo.web.ParadaAssembler;

public class ParadaServiceImpl implements ParadaServiceInterface {

    @Autowired
    private ParadaDAOInterface paradaDAO;

    @Override
    public ParadaModelo create(ParadaModelo paradaModelo) {
        // Convertimos el modelo a la entidad
        Parada parada = ParadaAssembler.toDomain(paradaModelo);
        // Guardamos la entidad en la base de datos
        Parada paradaGuardada = paradaDAO.save(parada);
        // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
        return ParadaAssembler.toView(paradaGuardada);
    }

    @Override
    public ParadaModelo save(ParadaModelo paradaModelo) {
        // Convertimos el modelo a la entidad
        Parada parada = ParadaAssembler.toDomain(paradaModelo);
        // Guardamos la entidad en la base de datos (puede ser creación o actualización)
        Parada paradaGuardada = paradaDAO.save(parada);
        // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
        return ParadaAssembler.toView(paradaGuardada);
    }

    @Override
    public void delete(long id) {
        // Buscamos la parada por ID
        Optional<Parada> paradaOptional = paradaDAO.findById(id);
        if (paradaOptional.isPresent()) {
            // Si la parada existe, la eliminamos
            paradaDAO.delete(paradaOptional.get());
        } else {
            // Si no existe, podrías lanzar una excepción o manejarlo de otra forma
            throw new RuntimeException("Parada no encontrada con el ID: " + id);
        }
    }

    @Override
    public ParadaModelo findById(int id) {
        // Buscamos la parada por ID
        Optional<Parada> paradaOptional = paradaDAO.findById((long) id);
        if (paradaOptional.isPresent()) {
            // Si la parada existe, la convertimos al modelo y la retornamos
            return ParadaAssembler.toView(paradaOptional.get());
        } else {
            // Si no se encuentra la parada, retornamos null o podrías lanzar una excepción
            return null;
        }
    }

    @Override
    public List<ParadaModelo> findAll() {
        // Obtenemos todas las paradas de la base de datos
        List<Parada> paradas = (List<Parada>) paradaDAO.findAll();
        // Convertimos todas las entidades a modelos
        List<ParadaModelo> paradaModelos = paradas.stream()
                .map(ParadaAssembler::toView)
                .collect(Collectors.toList());
        return paradaModelos;
    }
}
