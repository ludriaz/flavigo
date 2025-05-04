package tfg.jordanlucia.aplicacion.flavigo.repository.puntoInteres;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres.Restaurante;



@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}