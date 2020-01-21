package ru.vladigeras.springneo4j.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladigeras.springneo4j.model.dto.NewLine;
import ru.vladigeras.springneo4j.model.dto.NewStation;
import ru.vladigeras.springneo4j.model.node.LineNode;
import ru.vladigeras.springneo4j.model.node.StationNode;
import ru.vladigeras.springneo4j.repository.LineRepository;
import ru.vladigeras.springneo4j.repository.StationRepository;
import ru.vladigeras.springneo4j.service.StationService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
		if (lineId != null) {
			Optional<LineNode> optionalLineEntity = lineRepository.findById(lineId);
			optionalLineEntity.ifPresent(lineEntity -> lineEntity.addStation(stationNode));
		}
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
