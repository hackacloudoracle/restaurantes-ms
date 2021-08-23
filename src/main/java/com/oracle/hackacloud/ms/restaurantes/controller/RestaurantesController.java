package com.oracle.hackacloud.ms.restaurantes.controller;

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

import com.oracle.hackacloud.ms.restaurantes.model.MensagemErro;
import com.oracle.hackacloud.ms.restaurantes.model.Restaurante;
import com.oracle.hackacloud.ms.restaurantes.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestaurantesController {
	
	@Autowired
	RestauranteRepository restauranteRepository;
	
	@PostMapping
	public ResponseEntity<Restaurante> criar(@RequestBody Restaurante restaurante) {
		restauranteRepository.save(restaurante);
		return new ResponseEntity<Restaurante>(restaurante, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> consultar(@PathVariable Long id) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(id);
		if(restaurante.isEmpty()) {
			return new ResponseEntity<Object>(new MensagemErro("Restaurante não encontrado", "Não existe restaurante com o id: " + id), HttpStatus.OK);
		}
		return new ResponseEntity<Object>(restaurante.get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> descadastrar(@PathVariable Long id) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(id);
		if(restaurante.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		restauranteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
