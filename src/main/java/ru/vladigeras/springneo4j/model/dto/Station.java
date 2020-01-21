package ru.vladigeras.springneo4j.model.dto;

/**
 * @author vladi_geras on 09.01.2020
 */
public class Station {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public Station setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Station setName(String name) {
		this.name = name;
		return this;
	}
}
