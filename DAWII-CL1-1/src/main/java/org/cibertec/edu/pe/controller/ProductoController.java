package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductoService;
import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	private IProductoService servicio;
	
	
	// Método para Listar
		@GetMapping("/comprar")	// http://localhost:8080/comprar
		public String Listado(Model m) {
			List<Producto> lista = servicio.list();
			m.addAttribute("productos", lista);
			
			return "productos";	// compras.html
		}
		
		@GetMapping("/search/{id}")
		public String search(@PathVariable String id, Model m) {
			Optional<Producto> p = servicio.search(id);
			m.addAttribute("product", p);
			return "searchProductById";
		}
		
		@GetMapping("/create")
		public String create(Model m) {
			m.addAttribute("product", new Producto());
			return "createNewProduct";
		}
		
		@PostMapping("/save")
		public String save(@Validated Producto p, Model m) {
			servicio.save(p);
			return "redirect:/list";
		}
		
		@GetMapping("/update/{id}")
		public String update(@PathVariable String id, Model m) {
			Optional<Producto> p = servicio.search(id);
			m.addAttribute("product", p);
			return "updateProduct";
		}
		
		@GetMapping("/delete")
		public String delete(@PathVariable String id, Model m) {
			servicio.delete(id);
			return "redirect:/list";
		}

}