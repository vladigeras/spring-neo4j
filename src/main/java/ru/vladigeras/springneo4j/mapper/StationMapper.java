package ru.vladigeras.springneo4j.mapper;

import ru.vladigeras.springneo4j.model.dto.Line;
import ru.vladigeras.springneo4j.model.dto.Station;
import ru.vladigeras.springneo4j.model.entity.LineEntity;
import ru.vladigeras.springneo4j.model.entity.StationEntity;

/**
 * @author vladi_geras on 09.01.2020
 */
public class StationMapper {

	private StationMapper() {

	}

	public static Station of(StationEntity from) {
		return new Station()
				.setId(from.getId())
				.setName(from.getName());
	}

	public static Line of(LineEntity from) {
		return new Line()
				.setId(from.getId())
				.setName(from.getName());
	}
}
