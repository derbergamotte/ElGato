package com.ak.elgato.api.services;

import java.util.List;

import com.ak.elgato.api.dto.GatoDto;

public interface IGatoService {
	public List<GatoDto> getAllGatos();

	GatoDto addGato(GatoDto gatoDto);

	GatoDto getGatoById(int id);

	void updateGato(int id, GatoDto gatoDto);

	void delete(int id);
}
