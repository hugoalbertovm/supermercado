package com.supermercado.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticulo;

    private String descripcion;
    private double precio;
    private int existencias;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
