package ru.vladigeras.springneo4j.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladigeras.springneo4j.model.dto.NewLine;
import ru.vladigeras.springneo4j.model.dto.NewStation;
import ru.vladigeras.springneo4j.model.entity.LineEntity;
import ru.vladigeras.springneo4j.model.entity.StationEntity;
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
	public List<StationEntity> get() {
		List<StationEntity> result = new ArrayList<>();
		Iterator<StationEntity> iterator = stationRepository.findAll().iterator();
		iterator.forEachRemaining(result::add);
		return result;
	}

	@Transactional
	@Override
	public void save(NewStation station) {
		StationEntity stationEntity = new StationEntity();
		stationEntity.setName(station.getName());

		Long lineId = station.getLineId();
		if (lineId != null) {
			Optional<LineEntity> optionalLineEntity = lineRepository.findById(lineId);
			optionalLineEntity.ifPresent(lineEntity -> lineEntity.addStation(stationEntity));
		}
		stationRepository.save(stationEntity);
	}

	@Transactional
	@Override
	public void save(NewLine line) {
		LineEntity lineEntity = new LineEntity();
		lineEntity.setName(line.getName());
		lineRepository.save(lineEntity);
	}

	@Transactional(readOnly = true)
	@Override
	public List<LineEntity> getLines() {
		List<LineEntity> result = new ArrayList<>();
		Iterator<LineEntity> iterator = lineRepository.findAll().iterator();
		iterator.forEachRemaining(result::add);
		return result;
	}
}
