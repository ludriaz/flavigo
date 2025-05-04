package tfg.jordanlucia.aplicacion.flavigo.web;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.ParadaPuntoInteres;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaPuntoInteresModelo;

public class ParadaPuntoInteresAssembler {

    // Convierte de entidad a modelo
    public static ParadaPuntoInteresModelo toView(ParadaPuntoInteres entidad) {
        if (entidad == null) {
            return null;
        }

        ParadaPuntoInteresModelo modelo = new ParadaPuntoInteresModelo();
        modelo.setIdParada(entidad.getIdParada());
        modelo.setIdPuntoInteres(entidad.getIdPuntoInteres());
        modelo.setOrdenEnParada(entidad.getOrdenEnParada());
        modelo.setNotasAdicionales(entidad.getNotasAdicionales());

        return modelo;
    }

    // Convierte de modelo a entidad
    public static ParadaPuntoInteres toDomain(ParadaPuntoInteresModelo modelo) {
        if (modelo == null) {
            return null;
        }

        ParadaPuntoInteres entidad = new ParadaPuntoInteres();
        entidad.setIdParada(modelo.getIdParada());
        entidad.setIdPuntoInteres(modelo.getIdPuntoInteres());
        entidad.setOrdenEnParada(modelo.getOrdenEnParada());
        entidad.setNotasAdicionales(modelo.getNotasAdicionales());

        return entidad;
    }
}
