package tfg.jordanlucia.aplicacion.flavigo.web;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Empresa;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.EmpresaModelo;



public class EmpresaAssembler {

    // Método para convertir de Entidad a Modelo
    public static EmpresaModelo toView(Empresa empresa) {
        if (empresa == null) {
            return null;
        }
        EmpresaModelo modelo = new EmpresaModelo();
        modelo.setId(empresa.getId());
        modelo.setNombre(empresa.getNombre());
        modelo.setApellido1(empresa.getApellido1());
        modelo.setApellido2(empresa.getApellido2());
        modelo.setCif(empresa.getCif());
        modelo.setTipoPlan(empresa.getTipoPlan());
        modelo.setFechaAlta(empresa.getFechaAlta());
        modelo.setEmail(empresa.getEmail());
        modelo.setTelefono(empresa.getTelefono());
     //   modelo.setPuntoDeInteres(empresa.getPuntoDeInteres());
        return modelo;
    }

    // Método para convertir de Modelo a Entidad
    public static Empresa toDomain(EmpresaModelo modelo) {
        if (modelo == null) {
            return null;
        }
        Empresa empresa = new Empresa();
        empresa.setId(modelo.getId());
        empresa.setNombre(modelo.getNombre());
        empresa.setApellido1(modelo.getApellido1());
        empresa.setApellido2(modelo.getApellido2());
        empresa.setCif(modelo.getCif());
        empresa.setTipoPlan(modelo.getTipoPlan());
        empresa.setFechaAlta(modelo.getFechaAlta());
        empresa.setEmail(modelo.getEmail());
        empresa.setTelefono(modelo.getTelefono());
    //    empresa.setPuntoDeInteres(modelo.getPuntoDeInteres());
        return empresa;
    }
}
