package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Ruta;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.RutaModelo;
import tfg.jordanlucia.aplicacion.flavigo.repository.RutaDAOInterface;
import tfg.jordanlucia.aplicacion.flavigo.web.RutaAssembler;

public class RutaServiceImpl implements RutaServiceInterface {

    @Autowired
    private RutaDAOInterface rutaDAO;

    @Override
    public RutaModelo create(RutaModelo rutaModelo) {
        // Convertimos el modelo a la entidad
        Ruta ruta = RutaAssembler.toDomain(rutaModelo);
        // Guardamos la entidad en la base de datos
        Ruta rutaGuardada = rutaDAO.save(ruta);
        // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
        return RutaAssembler.toView(rutaGuardada);
    }

    @Override
    public RutaModelo save(RutaModelo rutaModelo) {
        // Convertimos el modelo a la entidad
        Ruta ruta = RutaAssembler.toDomain(rutaModelo);
        // Guardamos la entidad en la base de datos (puede ser creación o actualización)
        Ruta rutaGuardada = rutaDAO.save(ruta);
        // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
        return RutaAssembler.toView(rutaGuardada);
    }

    @Override
    public void delete(long id) {
        // Buscamos la Ruta por ID
        Optional<Ruta> rutaOptional = rutaDAO.findById(id);
        if (rutaOptional.isPresent()) {
            // Si la Ruta existe, la eliminamos
            rutaDAO.delete(rutaOptional.get());
        } else {
            // Si no existe, podrías lanzar una excepción o manejarlo de otra forma
            throw new RuntimeException("Ruta no encontrada con el ID: " + id);
        }
    }

    @Override
    public RutaModelo findById(int id) {
        // Buscamos la Ruta por ID
        Optional<Ruta> rutaOptional = rutaDAO.findById((long) id);
        if (rutaOptional.isPresent()) {
            // Si la Ruta existe, la convertimos al modelo y la retornamos
            return RutaAssembler.toView(rutaOptional.get());
        } else {
            // Si no se encuentra la Ruta, retornamos null o podrías lanzar una excepción
            return null;
        }
    }

    @Override
    public List<RutaModelo> findAll() {
        // Obtenemos todas las Rutas de la base de datos
        List<Ruta> rutas = (List<Ruta>) rutaDAO.findAll();
        // Convertimos todas las entidades a modelos
        List<RutaModelo> rutaModelos = rutas.stream()
                .map(RutaAssembler::toView)
                .collect(Collectors.toList());
        return rutaModelos;
    }
}
