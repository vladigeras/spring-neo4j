package ru.vladigeras.springneo4j.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author vladi_geras on 09.01.2020
 */
@ApiModel(description = "Line info")
public class Line {
	@ApiModelProperty("identifier")
	private Long id;

	@ApiModelProperty("line name")
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
