package tfg.jordanlucia.aplicacion.flavigo.business.service;

import java.util.List;
import java.util.Optional;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Empresa;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.EmpresaModelo;


public interface EmpresaServiceInterface {

    // Crear una nueva empresa
    public EmpresaModelo create(EmpresaModelo empresa);

    // Actualizar una empresa existente
    public EmpresaModelo save(EmpresaModelo empresa);

    // Eliminar una empresa por ID
    public void delete(Integer id);

    // Buscar una empresa por ID
    public EmpresaModelo findById(Integer id);

    // Obtener todas las empresas
    public List<EmpresaModelo> findAll();
    
    Optional<Empresa> findByNombre(String username);
    
}
