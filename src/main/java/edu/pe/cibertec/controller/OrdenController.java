package edu.pe.cibertec.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pe.cibertec.model.Orden;

import edu.pe.cibertec.service.IOrdenService;


@Controller
public class OrdenController {

    @Autowired
    private IOrdenService servicio;

    @GetMapping("/listOrdenes")
    public String listarOrdenes(Model modelo) {
        modelo.addAttribute("listOrdenes", servicio.listarOrdenes());
        return "listOrdenes"; // nombre de la vista
    }

    @GetMapping("/nuevaOrden")
    public String newOrden(Model modelo) {
        modelo.addAttribute("orden", new Orden());
        modelo.addAttribute("libros", servicio.listarLibros()); // Lista de libros para el formulario
        return "formOrdenes"; // Nombre de la vista del formulario para nueva orden
    }

    @PostMapping("/saveOrden")
    public String saveOrden(@RequestParam("fechaOrden") String fechaOrdenStr, Model model) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaOrden = sdf.parse(fechaOrdenStr);
            
            Orden orden = new Orden();
            orden.setFechaOrden(fechaOrden);
            // Establecer otros campos de la orden aquí
            
            servicio.guardarOrden(orden);
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al convertir la fecha.");
            return "formOrdenes"; // Retorna al formulario en caso de error
        }
        
        return "redirect:/listOrdenes";
    }

    @GetMapping("/editar1/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable int id, Model modelo) {
        Optional<Orden> orden = servicio.buscarOrden(id);
        if (orden.isPresent()) {
            modelo.addAttribute("orden", orden.get()); // Añade la orden al modelo
            modelo.addAttribute("libros", servicio.listarLibros()); // Lista de libros para el formulario
            return "formOrdenes"; // Devuelve la vista del formulario
        } else {
            return "redirect:/listOrdenes"; // Redirige si la orden no existe
        }
    }

    @GetMapping("/eliminar1/{id}")
    public String deleteOrden(@PathVariable int id) {
        servicio.eliminarOrden(id);
        return "redirect:/listOrdenes"; // Redirige a la lista de órdenes después de eliminar
    }
}