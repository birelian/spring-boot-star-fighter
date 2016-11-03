package net.birelian.api.controller;

import java.util.List;

import net.birelian.model.StarFighter;
import net.birelian.service.StarFighterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = StarFighterController.STAR_FIGHTER_BASE_URL_MAPPING)
class StarFighterController {

	static final String STAR_FIGHTER_BASE_URL_MAPPING = "/api/star-fighter";
	static final String STAR_FIGHTER_MAPPING = "/{starFighterId}";

	private final StarFighterService service;

	@Autowired
	public StarFighterController(StarFighterService service) {
		this.service = service;
	}

	@GetMapping
	public List<StarFighter> findAll() {
		return service.findAll();
	}

	@GetMapping(value = STAR_FIGHTER_MAPPING)
	public StarFighter getById(@PathVariable Integer starFighterId) {
		return service.findOne(starFighterId);
	}

	@PostMapping
	public StarFighter add(@RequestBody StarFighter starFighter) {
		return service.save(starFighter);
	}

	@PutMapping
	public StarFighter update(@RequestBody StarFighter starFighter) {
		return service.save(starFighter);
	}

	@DeleteMapping(value = STAR_FIGHTER_MAPPING)
	public void delete(@PathVariable Integer starFighterId) {
		service.delete(starFighterId);
	}

}
