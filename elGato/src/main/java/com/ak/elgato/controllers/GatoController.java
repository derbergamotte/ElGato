package com.ak.elgato.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.elgato.api.dto.GatoDto;
import com.ak.elgato.api.services.IGatoService;

@RestController
@RequestMapping("/cats")
public class GatoController {
	
	@Autowired
	IGatoService gatoService;
	
	@GetMapping
	public List<GatoDto> getAllGatos() {
		return gatoService.getAllGatos();
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GatoDto addGato(@RequestBody GatoDto gatoDto) {
		return gatoService.addGato(gatoDto);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateGato(@PathVariable int id, @RequestBody GatoDto gatoDto) {
		gatoService.updateGato(id, gatoDto);
	}

	@GetMapping(value = "/{id}")
	public GatoDto getGato(@PathVariable int id) {
		return gatoService.getGatoById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteGato(@PathVariable int id) {
		gatoService.delete(id);
	}
}
