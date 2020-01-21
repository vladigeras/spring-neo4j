package ru.vladigeras.springneo4j.model.dto;

/**
 * @author vladi_geras on 09.01.2020
 */
public class Line {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public Line setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Line setName(String name) {
		this.name = name;
		return this;
	}
}
