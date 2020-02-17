package ru.vladigeras.springneo4j.model.node;

import org.neo4j.ogm.annotation.*;
import ru.vladigeras.springneo4j.constant.RelationshipConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vladi_geras on 09.01.2020
 */
@NodeEntity("Station")
public class StationNode {
	@Id
	@GeneratedValue
	private Long id;

	@Property(name = "name")
	private String name;

	@Relationship(type = RelationshipConstant.CONTAINS_IN)
	private LineNode line;

	@Relationship(type = RelationshipConstant.CONNECTED_TO, direction = Relationship.UNDIRECTED)
	private List<Neighborhood> neighbors = new ArrayList<>();

	public void addNeighbor(Neighborhood neighborhood) {
		if (neighborhood != null) {
			if (neighbors == null) neighbors = new ArrayList<>();
			neighbors.add(neighborhood);
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public StationNode setName(String name) {
		this.name = name;
		return this;
	}

	public LineNode getLine() {
		return line;
	}

	public StationNode setLine(LineNode line) {
		this.line = line;
		return this;
	}

	public List<Neighborhood> getNeighbors() {
		return neighbors;
	}
}
