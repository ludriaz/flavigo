package tfg.jordanlucia.aplicacion.flavigo.web;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.ParadaRuta;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.ParadaRutaModelo;

public class ParadaRutaAssembler {

    // Método para convertir de Entidad a Modelo
    public static ParadaRutaModelo toView(ParadaRuta paradaRuta) {
        if (paradaRuta == null) {
            return null;
        }
        ParadaRutaModelo modelo = new ParadaRutaModelo();
        modelo.setId(paradaRuta.getId());
        modelo.setRuta(RutaAssembler.toView(paradaRuta.getRuta())); // Suponiendo que tienes un RutaAssembler
        modelo.setParada(ParadaAssembler.toView(paradaRuta.getParada())); // Suponiendo que tienes un ParadaAssembler
        return modelo;
    }

    // Método para convertir de Modelo a Entidad
    public static ParadaRuta toDomain(ParadaRutaModelo modelo) {
        if (modelo == null) {
            return null;
        }
        ParadaRuta paradaRuta = new ParadaRuta();
        paradaRuta.setId(modelo.getId());
        paradaRuta.setRuta(RutaAssembler.toDomain(modelo.getRuta())); // Suponiendo que tienes un RutaAssembler
        paradaRuta.setParada(ParadaAssembler.toDomain(modelo.getParada())); // Suponiendo que tienes un ParadaAssembler
        return paradaRuta;
    }
}
