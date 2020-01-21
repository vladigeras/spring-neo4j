package ru.vladigeras.springneo4j.service;

import ru.vladigeras.springneo4j.model.dto.NewLine;
import ru.vladigeras.springneo4j.model.dto.NewStation;
import ru.vladigeras.springneo4j.model.node.LineNode;
import ru.vladigeras.springneo4j.model.node.StationNode;

import java.util.List;

/**
 * @author vladi_geras on 09.01.2020
 */
public interface StationService {
	List<StationNode> get();

	void save(NewStation station);

	void save(NewLine line);

	List<LineNode> getLines();
}
