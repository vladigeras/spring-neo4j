package ru.vladigeras.springneo4j.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author vladi_geras on 09.01.2020
 */
@ApiModel(description = "Station info")
public class Station {
	@ApiModelProperty("identifier")
	private Long id;

	@ApiModelProperty("station name")
	private String name;

	@ApiModelProperty("line identifier")
	private Long lineId;

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

	public Long getLineId() {
		return lineId;
	}

	public Station setLineId(Long lineId) {
		this.lineId = lineId;
		return this;
	}
}
