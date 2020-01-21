package ru.vladigeras.springneo4j.model.dto;

/**
 * @author vladi_geras on 09.01.2020
 */
public class NewStation {
	private String name;
	private Long lineId;

	public String getName() {
		return name;
	}

	public NewStation setName(String name) {
		this.name = name;
		return this;
	}

	public Long getLineId() {
		return lineId;
	}

	public NewStation setLineId(Long lineId) {
		this.lineId = lineId;
		return this;
	}
}
