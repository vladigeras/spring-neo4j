package ru.vladigeras.springneo4j.model.entity;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vladi_geras on 09.01.2020
 */
@NodeEntity("Line")
public class LineEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Property(name = "name")
	private String name;

	@Relationship(type = "CONTAINS_IN", direction = Relationship.INCOMING)
	private List<StationEntity> stations = new ArrayList<>();

	public void addStation(StationEntity station) {
		if (station != null) {
			if (stations == null) stations = new ArrayList<>();
			station.setLine(this);
			stations.add(station);
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LineEntity setName(String name) {
		this.name = name;
		return this;
	}

	public List<StationEntity> getStations() {
		return stations;
	}

}
