package com.supermercado.service;

import com.supermercado.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    List<Articulo> getArticulos(boolean activos);

    Articulo getArticulo(Articulo articulo);

    void save(Articulo articulo);

    void delete(Articulo articulo);
}
