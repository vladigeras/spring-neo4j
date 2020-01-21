package ru.vladigeras.springneo4j.model.node;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vladi_geras on 09.01.2020
 */
@NodeEntity("Line")
public class LineNode {
	@Id
	@GeneratedValue
	private Long id;

	@Property(name = "name")
	private String name;

	@Relationship(type = "CONTAINS_IN", direction = Relationship.INCOMING)
	private List<StationNode> stations = new ArrayList<>();

	public void addStation(StationNode station) {
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

	public LineNode setName(String name) {
		this.name = name;
		return this;
	}

	public List<StationNode> getStations() {
		return stations;
	}

}
