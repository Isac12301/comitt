package edu.pe.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pe.cibertec.model.Libro;
import edu.pe.cibertec.service.ILibroService;

@Controller

	public class LibroController {

	    @Autowired
	    private ILibroService libroService;
	    
	   
		
	    @GetMapping("/listLibros")
	    public String listarLibros(Model modelo) {
	        modelo.addAttribute("listLibros", libroService.listarLibros());
	        return "listLibros"; 
	    }

	    @GetMapping("/nuevo")
	    public String mostrarFormularioNuevo(Model model) {
	        model.addAttribute("libro", new Libro());
	        return "formLibros";  
	    }

	    @PostMapping("/save")
	    public String guardarLibro(@ModelAttribute Libro libro) {
	        libroService.guardarLibro(libro);
	        return "redirect:/listLibros"; 
	    }

	    @GetMapping("/editar/{codigo}")
		public String editCodigo(@PathVariable int codigo, Model modelo) {
			modelo.addAttribute("libro", libroService.buscarLibro(codigo));
			return  "formLibros";
		}
	
	    @PostMapping("/actualizar/{codigo}")
	    public String actualizarLibro(@PathVariable int libroid, @ModelAttribute Libro libro) {
	        libro.setLibroid(libroid);  
	        libroService.guardarLibro(libro);
	        return "redirect:/listLibros";  
	    }

	    @GetMapping("/eliminar/{codigo}")
		public String deleteUsuario(@PathVariable int codigo) {
			libroService.eliminarLibro(codigo);
			return  "redirect:/listLibros";
		}
		
	}