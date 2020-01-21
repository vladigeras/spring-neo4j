package ru.vladigeras.springneo4j.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "Stations")
@RestController
@RequestMapping("/v1/stations")
public class StationController {
	private final StationService stationService;

	public StationController(StationService stationService) {
		this.stationService = stationService;
	}

	@ApiOperation("Get stations")
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<Station> get() {
		return stationService.get()
				.stream()
				.map(StationMapper::of)
				.collect(Collectors.toList());
	}

	@ApiOperation("Create station")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@ApiParam("Station info")
					@RequestBody NewStation station) {
		stationService.save(station);
	}

	@ApiOperation("Get lines")
	@GetMapping("/lines")
	@ResponseStatus(HttpStatus.OK)
	public List<Line> getLines() {
		return stationService.getLines()
				.stream()
				.map(StationMapper::of)
				.collect(Collectors.toList());
	}

	@ApiOperation("Create line")
	@PostMapping("/lines")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@ApiParam("Line info")
					@RequestBody NewLine line) {
		stationService.save(line);
	}
}
