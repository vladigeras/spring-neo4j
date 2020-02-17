package ru.vladigeras.springneo4j.model.node;

import org.neo4j.ogm.annotation.*;

/**
 * @author vladi_geras on 21.01.2020
 */
@RelationshipEntity("CONNECTED_TO")
public class Neighborhood {
	@Id
	@GeneratedValue
	private Long id;

	// time between stations (in minutes)
	@Property("travelTime")
	private int travelTime;

	// flag to transfer line between two stations
	@Property("isChangingLine")
	private boolean isChangingLine;

	@StartNode
	private StationNode stationFrom;

	@EndNode
	private StationNode stationTo;

	public Neighborhood() {
	}

	public Neighborhood(int travelTime, StationNode stationFrom, StationNode stationTo, boolean isChangingLine) {
		this.travelTime = travelTime;
		this.stationFrom = stationFrom;
		this.stationTo = stationTo;
		this.isChangingLine = isChangingLine;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public Neighborhood setTravelTime(int travelTime) {
		this.travelTime = travelTime;
		return this;
	}

	public StationNode getStationFrom() {
		return stationFrom;
	}

	public Neighborhood setStationFrom(StationNode stationFrom) {
		this.stationFrom = stationFrom;
		return this;
	}

	public StationNode getStationTo() {
		return stationTo;
	}

	public Neighborhood setStationTo(StationNode stationTo) {
		this.stationTo = stationTo;
		return this;
	}

	public boolean isChangingLine() {
		return isChangingLine;
	}

	public Neighborhood setChangingLine(boolean changingLine) {
		isChangingLine = changingLine;
		return this;
	}
}
