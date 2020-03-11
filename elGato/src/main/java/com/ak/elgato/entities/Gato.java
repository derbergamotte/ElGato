package com.ak.elgato.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gato_table")
public class Gato {
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nickname", length = 45)
	private String nickname;
	@Column(name = "breed", length = 45)
	private String breed;
	
	public Gato(String nickname, String breed) {
		this.nickname = nickname;
		this.breed = breed;
	}
}
