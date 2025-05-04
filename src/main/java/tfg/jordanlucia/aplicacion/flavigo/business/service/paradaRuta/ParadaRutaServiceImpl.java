package tfg.jordanlucia.aplicacion.flavigo.business.service.paradaRuta;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.ParadaRuta;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaRutaModelo;
import tfg.jordanlucia.aplicacion.flavigo.repository.ParadaRutaDAOInterface;
import tfg.jordanlucia.aplicacion.flavigo.web.ParadaRutaAssembler;

public class ParadaRutaServiceImpl implements ParadaRutaServiceInterface {

    @Autowired
    private ParadaRutaDAOInterface paradaRutaDAO;

    @Override
    public ParadaRutaModelo create(ParadaRutaModelo paradaRutaModelo) {
        // Convertimos el modelo a la entidad
        ParadaRuta paradaRuta = ParadaRutaAssembler.toDomain(paradaRutaModelo);
        // Guardamos la entidad en la base de datos
        ParadaRuta paradaRutaGuardada = paradaRutaDAO.save(paradaRuta);
        // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
        return ParadaRutaAssembler.toView(paradaRutaGuardada);
    }

    @Override
    public ParadaRutaModelo save(ParadaRutaModelo paradaRutaModelo) {
        // Convertimos el modelo a la entidad
        ParadaRuta paradaRuta = ParadaRutaAssembler.toDomain(paradaRutaModelo);
        // Guardamos la entidad en la base de datos (puede ser creación o actualización)
        ParadaRuta paradaRutaGuardada = paradaRutaDAO.save(paradaRuta);
        // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
        return ParadaRutaAssembler.toView(paradaRutaGuardada);
    }

    @Override
    public void delete(long id) {
        // Buscamos la ParadaRuta por ID
        Optional<ParadaRuta> paradaRutaOptional = paradaRutaDAO.findById(id);
        if (paradaRutaOptional.isPresent()) {
            // Si la ParadaRuta existe, la eliminamos
            paradaRutaDAO.delete(paradaRutaOptional.get());
        } else {
            // Si no existe, podrías lanzar una excepción o manejarlo de otra forma
            throw new RuntimeException("ParadaRuta no encontrada con el ID: " + id);
        }
    }

    @Override
    public ParadaRutaModelo findById(int id) {
        // Buscamos la ParadaRuta por ID
        Optional<ParadaRuta> paradaRutaOptional = paradaRutaDAO.findById((long) id);
        if (paradaRutaOptional.isPresent()) {
            // Si la ParadaRuta existe, la convertimos al modelo y la retornamos
            return ParadaRutaAssembler.toView(paradaRutaOptional.get());
        } else {
            // Si no se encuentra la ParadaRuta, retornamos null o podrías lanzar una excepción
            return null;
        }
    }

    @Override
    public List<ParadaRutaModelo> findAll() {
        // Obtenemos todas las ParadaRuta de la base de datos
        List<ParadaRuta> paradaRutas = (List<ParadaRuta>) paradaRutaDAO.findAll();
        // Convertimos todas las entidades a modelos
        List<ParadaRutaModelo> paradaRutaModelos = paradaRutas.stream()
                .map(ParadaRutaAssembler::toView)
                .collect(Collectors.toList());
        return paradaRutaModelos;
    }
}
