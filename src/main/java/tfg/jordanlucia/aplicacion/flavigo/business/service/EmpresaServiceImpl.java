package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Empresa;
import tfg.jordanlucia.aplicacion.flavigo.model.entity.Usuario;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.EmpresaModelo;
import tfg.jordanlucia.aplicacion.flavigo.repository.EmpresaDAOInterface;
import tfg.jordanlucia.aplicacion.flavigo.web.EmpresaAssembler;

public class EmpresaServiceImpl implements EmpresaServiceInterface{
	
	 @Autowired
	 private EmpresaDAOInterface empresaDAO;

	@Override
	public EmpresaModelo create(EmpresaModelo empresaModelo) {
	    // Convertimos el modelo a la entidad	
	    Empresa empresa = EmpresaAssembler.toDomain(empresaModelo);
	    // Guardamos la entidad en la base de datos
	    Empresa empresaGuardada = empresaDAO.save(empresa);
	    // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
	    return EmpresaAssembler.toView(empresaGuardada);
	}

	@Override
	public EmpresaModelo save(EmpresaModelo empresaModelo) {
	    // Convertimos el modelo a la entidad
	    Empresa empresa = EmpresaAssembler.toDomain(empresaModelo);
	    // Guardamos la entidad en la base de datos (puede ser creación o actualización)
	    Empresa empresaGuardada = empresaDAO.save(empresa);
	    // Convertimos la entidad guardada de nuevo al modelo y lo retornamos
	    return EmpresaAssembler.toView(empresaGuardada);
	}

	@Override
	public void delete(Integer id) {
	    // Buscamos la empresa por ID
	    Optional<Empresa> empresaOptional = empresaDAO.findById(id);
	    if (empresaOptional.isPresent()) {
	        // Si la empresa existe, la eliminamos
	        empresaDAO.delete(empresaOptional.get());
	    } else {
	        // Si no existe, podrías lanzar una excepción o manejarlo de otra forma
	        throw new RuntimeException("Empresa no encontrada con el ID: " + id);
	    }
	}

	@Override
	public EmpresaModelo findById(Integer id) {
	    // Buscamos la empresa por ID
	    Optional<Empresa> empresaOptional = empresaDAO.findById((Integer) id);
	    if (empresaOptional.isPresent()) {
	        // Si la empresa existe, la convertimos al modelo y la retornamos
	        return EmpresaAssembler.toView(empresaOptional.get());
	    } else {
	        // Si no se encuentra la empresa, retornamos null o podrías lanzar una excepción
	        return null;
	    }
	}

	@Override
	public List<EmpresaModelo> findAll() {
	    // Obtenemos todas las empresas de la base de datos
	    List<Empresa> empresas = (List<Empresa>) empresaDAO.findAll();
	    // Convertimos todas las entidades a modelos
	    List<EmpresaModelo> empresaModelos = empresas.stream()
	            .map(EmpresaAssembler::toView)
	            .collect(Collectors.toList());
	    return empresaModelos;
	}
	
	@Override
    public Optional<Empresa> findByNombre(String username) {
        return empresaDAO.findByNombre(username);
    }

}
