package tfg.jordanlucia.aplicacion.flavigo.model.entity.puntoInteres;

import jakarta.persistence.Entity;

import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import tfg.jordanlucia.aplicacion.flavigo.ENUMS.enums.CategoriaComercio;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
@Entity
@Table(name = "TD_COMERCIO")
@PrimaryKeyJoinColumn(name = "id") // Indicamos que la PK es la misma que la de PuntoInteres
public class Comercio extends PuntoInteres {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private CategoriaComercio categoria;

    @Column(columnDefinition = "TEXT")
    private String productos;

    // Getters y Setters

    public CategoriaComercio getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaComercio categoria) {
        this.categoria = categoria;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }
}