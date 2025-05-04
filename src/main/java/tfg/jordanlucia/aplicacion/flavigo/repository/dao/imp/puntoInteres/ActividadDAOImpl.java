package tfg.jordanlucia.aplicacion.flavigo.repository.dao.imp.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Actividad;
import tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres.ActividadDAO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.ActividadRepository;



@Repository
public class ActividadDAOImpl implements ActividadDAO {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public Actividad guardar(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    @Override
    public Optional<Actividad> buscarPorId(Integer id) {
        return actividadRepository.findById(id);
    }

    @Override
    public List<Actividad> buscarTodos() {
        return actividadRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        actividadRepository.deleteById(id);
    }
}