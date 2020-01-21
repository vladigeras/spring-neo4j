package ru.vladigeras.springneo4j.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author vladi_geras on 10.01.2020
 */
@ApiModel(description = "Line info")
public class NewLine {
	@ApiModelProperty("line name")
	private String name;

	public String getName() {
		return name;
	}

	public NewLine setName(String name) {
		this.name = name;
		return this;
	}
}
