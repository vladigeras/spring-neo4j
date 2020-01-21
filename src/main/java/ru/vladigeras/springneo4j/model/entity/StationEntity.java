package ru.vladigeras.springneo4j.model.entity;

import org.neo4j.ogm.annotation.*;

/**
 * @author vladi_geras on 09.01.2020
 */
@NodeEntity("Station")
public class StationEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Property(name = "name")
	private String name;

	@Relationship(type = "CONTAINS_IN")
	private LineEntity line;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public StationEntity setName(String name) {
		this.name = name;
		return this;
	}

	public LineEntity getLine() {
		return line;
	}

	public StationEntity setLine(LineEntity line) {
		this.line = line;
		return this;
	}
}
