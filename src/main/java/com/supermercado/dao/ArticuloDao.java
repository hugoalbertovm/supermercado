package com.supermercado.dao;

import com.supermercado.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloDao extends JpaRepository<Articulo, Long> {
}
