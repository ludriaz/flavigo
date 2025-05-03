package tfg.jordanlucia.aplicacion.flavigo.web;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.Usuario;
import tfg.jordanlucia.aplicacion.flavigo.model.modelos.UsuarioModelo;

public class UsuarioAssembler {

    // Método para convertir de Entidad a Modelo
    public static UsuarioModelo toView(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        UsuarioModelo modelo = new UsuarioModelo();
        modelo.setId(usuario.getId());
        modelo.setNombre(usuario.getNombre());
        modelo.setEmail(usuario.getEmail());
        modelo.setContrasena(usuario.getContrasena());
      //  modelo.setLocal(PuntoDeInteresAssembler.toView(usuario.getLocal())); // Asumiendo que tienes un PuntoDeInteresAssembler
        modelo.setRol(usuario.getRol());
        modelo.setFotoPerfil(usuario.getFotoPerfil());
        return modelo;
    }

    // Método para convertir de Modelo a Entidad
    public static Usuario toDomain(UsuarioModelo modelo) {
        if (modelo == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(modelo.getId());
        usuario.setNombre(modelo.getNombre());
        usuario.setEmail(modelo.getEmail());
        usuario.setContrasena(modelo.getContrasena());
      //  usuario.setLocal(PuntoDeInteresAssembler.toDomain(modelo.getLocal())); // Asumiendo que tienes un PuntoDeInteresAssembler
        usuario.setRol(modelo.getRol());
        usuario.setFotoPerfil(modelo.getFotoPerfil());
        return usuario;
    }
}
