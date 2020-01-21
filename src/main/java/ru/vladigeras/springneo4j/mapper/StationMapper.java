package ru.vladigeras.springneo4j.mapper;

import ru.vladigeras.springneo4j.model.dto.Line;
import ru.vladigeras.springneo4j.model.dto.Station;
import ru.vladigeras.springneo4j.model.node.LineNode;
import ru.vladigeras.springneo4j.model.node.StationNode;

/**
 * @author vladi_geras on 09.01.2020
 */
public class StationMapper {

	private StationMapper() {

	}

	public static Station of(StationNode from) {
		LineNode line = from.getLine();
		return new Station()
				.setId(from.getId())
				.setName(from.getName())
				.setLineId(line != null ? line.getId() : null);
	}

	public static Line of(LineNode from) {
		return new Line()
				.setId(from.getId())
				.setName(from.getName());
	}
}
