package ru.vladigeras.springneo4j.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author vladi_geras on 21.01.2020
 */
@ApiModel(description = "Neighbor info")
public class Neighbor {
	@ApiModelProperty("neighbor station identifier")
	private Long id;

	@ApiModelProperty("travel time between neighbors")
	private int travelTime;

	@ApiModelProperty("flag to change line between two stations")
	private boolean isChangingLine;

	public Neighbor() {
	}

	public Neighbor(Long id, int travelTime, boolean isChangingLine) {
		this.id = id;
		this.travelTime = travelTime;
		this.isChangingLine = isChangingLine;
	}

	public Long getId() {
		return id;
	}

	public Neighbor setId(Long id) {
		this.id = id;
		return this;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public Neighbor setTravelTime(int travelTime) {
		this.travelTime = travelTime;
		return this;
	}

	public boolean isChangingLine() {
		return isChangingLine;
	}

	public Neighbor setChangingLine(boolean changingLine) {
		isChangingLine = changingLine;
		return this;
	}
}
