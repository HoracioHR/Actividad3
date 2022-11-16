package com.example.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Categoria;
import com.example.demo.services.CategoriaService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("api/categoria")
public class CategoriaControllers {
	@Autowired
	private CategoriaService categoriaService;
	@ApiOperation(value="Crea las categorias",notes = "Devuelve un listado con todas las categorias")
	@PostMapping
	private ResponseEntity<Categoria>guardar(@RequestBody Categoria categoria){
		Categoria temporal=categoriaService.create(categoria);
		try {
			return ResponseEntity.created(new URI ("/api/categoria"+temporal.getIdCategoria())).body(temporal);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@ApiOperation(value="Busca las categorias.",notes = "Devuelve un listado con todas las categorias.")
	@GetMapping
	private ResponseEntity<List<Categoria>>listarTodasLasCategorias(){
		
			return ResponseEntity.ok(categoriaService.getAllCategorias());
		
	}
	@ApiOperation(value="Busca categorias por id.",notes = "Devuelve la categoria.")
	@GetMapping(value="{id}")
	private ResponseEntity<Optional<Categoria>>listarCategorias(@PathVariable("id") Long id){
		return ResponseEntity.ok(categoriaService.findById(id));
	}
	@ApiOperation(value="Elimina las categorias.",notes = "Elimina una categoria.")
	@DeleteMapping
	private ResponseEntity<Void>eliminarCategorias(@RequestBody Categoria categoria){
		categoriaService.delete(categoria);
		return ResponseEntity.ok().build();
	}
	
}

