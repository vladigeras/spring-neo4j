package ru.vladigeras.springneo4j.model.node;

import org.neo4j.ogm.annotation.*;

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

	@Relationship(type = "CONTAINS_IN")
	private LineNode line;

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
}
