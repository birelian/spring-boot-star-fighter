package net.birelian.service;

import net.birelian.model.StarFighter;
import net.birelian.repository.StarFighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarFighterServiceImpl implements StarFighterService {

	private final StarFighterRepository repository;

	@Autowired
	public StarFighterServiceImpl(StarFighterRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<StarFighter> findAll() {
		return repository.findAll();
	}

	@Override
	public StarFighter findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public StarFighter save(StarFighter starFighter) {
		return repository.save(starFighter);
	}

	@Override
	public void delete(StarFighter starFighter) {
		repository.delete(starFighter);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}


}
