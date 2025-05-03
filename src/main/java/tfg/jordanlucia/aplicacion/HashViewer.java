package tfg.jordanlucia.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HashViewer implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        String plainPassword = "tu_contrasena_de_prueba";
        String hashedPassword = passwordEncoder.encode(plainPassword);
        System.out.println("Hash de '" + plainPassword + "': " + hashedPassword);
        // La aplicación seguirá iniciándose normalmente después de esto.
        // Puedes comentar o eliminar este componente una vez que veas el hash.
    }
}