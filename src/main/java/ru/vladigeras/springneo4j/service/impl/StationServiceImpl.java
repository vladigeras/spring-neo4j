package ru.vladigeras.springneo4j.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladigeras.springneo4j.model.dto.Neighbor;
import ru.vladigeras.springneo4j.model.dto.NewLine;
import ru.vladigeras.springneo4j.model.dto.NewStation;
import ru.vladigeras.springneo4j.model.node.LineNode;
import ru.vladigeras.springneo4j.model.node.Neighborhood;
import ru.vladigeras.springneo4j.model.node.StationNode;
import ru.vladigeras.springneo4j.repository.LineRepository;
import ru.vladigeras.springneo4j.repository.StationRepository;
import ru.vladigeras.springneo4j.service.StationService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author vladi_geras on 09.01.2020
 */
@Service
public class StationServiceImpl implements StationService {
	private final StationRepository stationRepository;
	private final LineRepository lineRepository;

	public StationServiceImpl(StationRepository stationRepository, LineRepository lineRepository) {
		this.stationRepository = stationRepository;
		this.lineRepository = lineRepository;
	}

	@PostConstruct
	public void init() {
	}

	@Transactional(readOnly = true)
	@Override
	public List<StationNode> get() {
		List<StationNode> result = new ArrayList<>();
		Iterator<StationNode> iterator = stationRepository.findAll().iterator();
		iterator.forEachRemaining(result::add);
		return result;
	}

	@Transactional
	@Override
	public void save(NewStation station) {
		StationNode stationNode = new StationNode();
		stationNode.setName(station.getName());

		Long lineId = station.getLineId();
		if (lineId == null) throw new RuntimeException("Line is not specified");
		LineNode lineNode = lineRepository.findById(lineId)
				.orElseThrow(() -> new RuntimeException("Line is not found [id = " + lineId + "]"));
		lineNode.addStation(stationNode);

		List<Neighbor> neighbors = station.getNeighbors();
		neighbors.forEach(neighbor -> {
			Long neighborId = neighbor.getId();
			if (neighborId == null) throw new RuntimeException("Neighbor id is not specified");
			StationNode neighborNode = stationRepository.findById(neighborId)
					.orElseThrow(() -> new RuntimeException("Station is not found [id = " + neighborId + "]"));
			stationNode.addNeighbor(new Neighborhood(neighbor.getTravelTime(), stationNode, neighborNode, neighbor.isChangingLine()));
		});

		stationRepository.save(stationNode);
	}

	@Transactional
	@Override
	public void save(NewLine line) {
		LineNode lineNode = new LineNode();
		lineNode.setName(line.getName());
		lineRepository.save(lineNode);
	}

	@Transactional(readOnly = true)
	@Override
	public List<LineNode> getLines() {
		List<LineNode> result = new ArrayList<>();
		Iterator<LineNode> iterator = lineRepository.findAll().iterator();
		iterator.forEachRemaining(result::add);
		return result;
	}
}
