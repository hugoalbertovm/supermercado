package com.supermercado.controller;

import com.supermercado.domain.Articulo;
import com.supermercado.service.ArticuloService;
import com.supermercado.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/articulo/modifica";
    }

    @PostMapping("/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        model.addAttribute("articulo", articulo);
        return "/articulo/modifica";
    }

    @GetMapping("/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
}
