package tfg.jordanlucia.aplicacion.flavigo.web;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Ruta;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.RutaModelo;

public class RutaAssembler {

    // Método para convertir de Entidad a Modelo
    public static RutaModelo toView(Ruta ruta) {
        if (ruta == null) {
            return null;
        }
        RutaModelo modelo = new RutaModelo();
        modelo.setId(ruta.getId());
        modelo.setNombre(ruta.getNombre());
        modelo.setDescripcion(ruta.getDescripcion());
        modelo.setDuracionAproximada(ruta.getDuracionAproximada());
        modelo.setNivel(ruta.getNivel());
        modelo.setImagen(ruta.getImagen());
        modelo.setTipoRuta(ruta.getTipoRuta());
        return modelo;
    }

    // Método para convertir de Modelo a Entidad
    public static Ruta toDomain(RutaModelo modelo) {
        if (modelo == null) {
            return null;
        }
        Ruta ruta = new Ruta();
        ruta.setId(modelo.getId());
        ruta.setNombre(modelo.getNombre());
        ruta.setDescripcion(modelo.getDescripcion());
        ruta.setDuracionAproximada(modelo.getDuracionAproximada());
        ruta.setNivel(modelo.getNivel());
        ruta.setImagen(modelo.getImagen());
        ruta.setTipoRuta(modelo.getTipoRuta());
        return ruta;
    }
}
