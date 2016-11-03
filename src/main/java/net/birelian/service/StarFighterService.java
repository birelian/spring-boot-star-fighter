package net.birelian.service;

import net.birelian.model.StarFighter;

import java.util.List;

public interface StarFighterService {

	List<StarFighter> findAll();

	StarFighter findOne(Integer id);

	StarFighter save(StarFighter starFighter);

	void delete(StarFighter starFighter);

	void delete(Integer id);

}
