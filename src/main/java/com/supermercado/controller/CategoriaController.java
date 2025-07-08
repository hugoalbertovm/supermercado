package com.supermercado.controller;

import com.supermercado.domain.Categoria;
import com.supermercado.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/categoria/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modifica";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria, Model model) {
        try {
            categoriaService.delete(categoria);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            model.addAttribute("errorEliminar", "No se puede eliminar la categoría porque tiene artículos asociados.");
            return listado(model);
        }
        return "redirect:/categoria/listado";
    }

}
