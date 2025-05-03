package tfg.jordanlucia.aplicacion.flavigo.web;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Parada;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaModelo;

public class ParadaAssembler {

    // Método para convertir de Entidad a Modelo
    public static ParadaModelo toView(Parada parada) {
        if (parada == null) {
            return null;
        }
        ParadaModelo modelo = new ParadaModelo();
        modelo.setId(parada.getId());
        modelo.setNombre(parada.getNombre());
        modelo.setDescripcionBreve(parada.getDescripcionBreve());
        return modelo;
    }

    // Método para convertir de Modelo a Entidad
    public static Parada toDomain(ParadaModelo modelo) {
        if (modelo == null) {
            return null;
        }
        Parada parada = new Parada();
        parada.setId(modelo.getId());
        parada.setNombre(modelo.getNombre());
        parada.setDescripcionBreve(modelo.getDescripcionBreve());
        return parada;
    }
}