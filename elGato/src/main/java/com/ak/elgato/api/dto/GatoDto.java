package com.ak.elgato.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.ak.elgato.entities.Gato;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GatoDto {

	private int id;
	private String nickname;
	private String breed;
	
	public GatoDto(Gato gato) {
		this.id = gato.getId();
		this.nickname = gato.getNickname();
		this.breed = gato.getBreed();
	}
	
	public static List<GatoDto> convertList(List<Gato> entities) {
		List<GatoDto> gatos = new ArrayList<>();
		for (Gato entity : entities) {
			GatoDto dto = entityToDto(entity);
			gatos.add(dto);
		}
		return gatos;
	}

	public static GatoDto entityToDto(Gato entity) {
		GatoDto dto = new GatoDto();
		dto.setId(entity.getId());
		dto.setNickname(entity.getNickname());
		dto.setBreed(entity.getBreed());
		return dto;
	}
	
	public static Gato dtoToEntity(GatoDto dto) {
		Gato gato = new Gato();
		gato.setId(dto.getId());
		gato.setNickname(dto.getNickname());
		gato.setBreed(dto.getBreed());
		return gato;
	}
}
