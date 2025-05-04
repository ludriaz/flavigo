package tfg.jordanlucia.aplicacion.flavigo.repository.dao.imp.puntoInteres;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Turistico;
import tfg.jordanlucia.aplicacion.flavigo.repository.dao.puntoInteres.TuristicoDAO;
import tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres.TuristicoRepository;



@Repository
public class TuristicoDAOImpl implements TuristicoDAO {

    @Autowired
    private TuristicoRepository turisticoRepository;

    @Override
    public Turistico guardar(Turistico turistico) {
        return turisticoRepository.save(turistico);
    }

    @Override
    public Optional<Turistico> buscarPorId(Integer id) {
        return turisticoRepository.findById(id);
    }

    @Override
    public List<Turistico> buscarTodos() {
        return turisticoRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer id) {
        turisticoRepository.deleteById(id);
    }
}