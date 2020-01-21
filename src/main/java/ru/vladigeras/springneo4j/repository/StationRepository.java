package ru.vladigeras.springneo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import ru.vladigeras.springneo4j.model.node.StationNode;

/**
 * @author vladi_geras on 09.01.2020
 */
@Repository
public interface StationRepository extends Neo4jRepository<StationNode, Long> {
}
