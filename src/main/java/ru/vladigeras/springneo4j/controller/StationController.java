package ru.vladigeras.springneo4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vladigeras.springneo4j.mapper.StationMapper;
import ru.vladigeras.springneo4j.model.dto.Line;
import ru.vladigeras.springneo4j.model.dto.NewLine;
import ru.vladigeras.springneo4j.model.dto.NewStation;
import ru.vladigeras.springneo4j.model.dto.Station;
import ru.vladigeras.springneo4j.service.StationService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vladi_geras on 09.01.2020
 */
@RestController
@RequestMapping("/v1/stations")
public class StationController {
	private final StationService stationService;

	public StationController(StationService stationService) {
		this.stationService = stationService;
	}

	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<Station> get() {
		return stationService.get()
				.stream()
				.map(StationMapper::of)
				.collect(Collectors.toList());
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody NewStation station) {
		stationService.save(station);
	}

	@GetMapping("/lines")
	@ResponseStatus(HttpStatus.OK)
	public List<Line> getLines() {
		return stationService.getLines()
				.stream()
				.map(StationMapper::of)
				.collect(Collectors.toList());
	}

	@PostMapping("/lines")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody NewLine line) {
		stationService.save(line);
	}
}
