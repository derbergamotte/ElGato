package com.ak.elgato.api.dao;

import java.util.List;

import com.ak.elgato.entities.Gato;

public interface IGatoDao {

	Gato create(Gato gato);
	
	Gato get(Integer id);
	
	void update (Gato gato);
	
	void delete (Gato gato);
	
	List<Gato> getAll();
}
