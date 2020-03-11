package com.ak.elgato.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ak.elgato.api.dto.GatoDto;
import com.ak.elgato.api.services.IGatoService;
import com.ak.elgato.dao.GatoDao;
import com.ak.elgato.entities.Gato;

@Service
@Transactional
public class GatoService implements IGatoService{

	@Autowired
	private GatoDao gatoDao;
	
	@Override
	public List<GatoDto> getAllGatos() {
		return GatoDto.convertList(gatoDao.getAll());
	}

	@Override
	public GatoDto addGato(GatoDto gatoDto) {
		Gato gato = new Gato();
		gato.setNickname(gatoDto.getNickname());
		gato.setBreed(gatoDto.getBreed());
		return GatoDto.entityToDto(gatoDao.create(gato));
	}

	@Override
	public GatoDto getGatoById(int id) {
		return GatoDto.entityToDto(getDaoById(id));
	}

	@Override
	public void updateGato(int id, GatoDto gatoDto) {
		Gato gato = getDaoById(id);
		if (!StringUtils.isEmpty(gatoDto.getNickname())) {
			gato.setNickname(gatoDto.getNickname());
		}
		if (!StringUtils.isEmpty(gatoDto.getBreed())) {
			gato.setBreed(gatoDto.getBreed());
		}
		gatoDao.update(gato);		
	}

	@Override
	public void delete(int id) {
		gatoDao.delete(getDaoById(id));
	}

	private Gato getDaoById(int id) {
		return Optional.of(gatoDao.get(id)).get();
	}
}
