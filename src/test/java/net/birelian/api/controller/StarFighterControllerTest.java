package net.birelian.api.controller;

import io.restassured.http.ContentType;
import net.birelian.model.StarFighter;
import net.birelian.repository.StarFighterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("DEV")
public class StarFighterControllerTest {

	private static final List<String> NAMES = Arrays.asList("Tie-Fighter", "X-Wing");

	@Autowired
	private StarFighterRepository repository;

	@LocalServerPort
	int port;

	private List<StarFighter> starFighters;

	@Before
	public void setUp() throws Exception {

		RestAssured.port = port;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		initializeDatabase();

	}

	private void initializeDatabase() {

		repository.deleteAll();
		starFighters = NAMES.stream().map(StarFighter::new).collect(Collectors.toList());
		repository.save(starFighters);
	}

	@Test
	public void getAllStarFightersShouldReturnOk() {

		given()

		.when()
			.get(StarFighterController.STAR_FIGHTER_BASE_URL_MAPPING)

		.then()
			.statusCode(200)
			.body("id", hasSize(NAMES.size()))
			.body("name", hasItems(NAMES.toArray()));

	}

	@Test
	public void postANewStarFighterShouldReturnAStarFighterWithId() {

		List<StarFighter> starFighters = Arrays.asList(new StarFighter("Test"), new StarFighter("Test2"));

		given()
			.body(starFighters)
			.contentType(ContentType.JSON)

		.when()
			.post(StarFighterController.STAR_FIGHTER_BASE_URL_MAPPING)

		.then()
			.statusCode(200)
			.body("id", hasSize(2));
	}

	@Test
	public void deleteAStarFighterShouldReturnOk() {

		StarFighter starFighterToDelete = starFighters.get(0);

		given()

		.when()
			.delete(StarFighterController.STAR_FIGHTER_BASE_URL_MAPPING
					+ StarFighterController.STAR_FIGHTER_MAPPING.replace("{starFighterId}", String.valueOf(starFighterToDelete.getId())))

		.then()
			.statusCode(200);

	}

}
