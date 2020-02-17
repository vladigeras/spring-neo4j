package ru.vladigeras.springneo4j.mapper;

import ru.vladigeras.springneo4j.model.dto.Line;
import ru.vladigeras.springneo4j.model.dto.Neighbor;
import ru.vladigeras.springneo4j.model.dto.Station;
import ru.vladigeras.springneo4j.model.node.LineNode;
import ru.vladigeras.springneo4j.model.node.StationNode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vladi_geras on 09.01.2020
 */
public class StationMapper {

	private StationMapper() {

	}

	public static Station of(StationNode from) {
		Long id = from.getId();
		Station station = new Station()
				.setId(id)
				.setName(from.getName());

		LineNode line = from.getLine();
		if (line != null) station.setLineId(line.getId());

		List<Neighbor> neighbors = from.getNeighbors()
				.stream()
				.map(neighborhood -> {
					StationNode neighbor1 = neighborhood.getStationFrom();
					StationNode neighbor2 = neighborhood.getStationTo();
					Long neighborId = neighbor1.getId().equals(id) ? neighbor2.getId() : neighbor1.getId();
					return new Neighbor(neighborId, neighborhood.getTravelTime(), neighborhood.isChangingLine());
				})
				.collect(Collectors.toList());

		station.setNeighbors(neighbors);
		return station;
	}

	public static Line of(LineNode from) {
		return new Line()
				.setId(from.getId())
				.setName(from.getName());
	}
}
