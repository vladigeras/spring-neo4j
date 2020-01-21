package ru.vladigeras.springneo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import ru.vladigeras.springneo4j.model.node.LineNode;

/**
 * @author vladi_geras on 10.01.2020
 */
@Repository
public interface LineRepository extends Neo4jRepository<LineNode, Long> {
}
