package io.microservices.rating.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.microservices.rating.models.RatingData;
import io.microservices.rating.models.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingDataResource {
	
	@RequestMapping(method=RequestMethod.GET,  value ="/{movieId}")
	public RatingData getRatingData(@PathVariable("movieId") String movieId) {
		return new RatingData(movieId, 4);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users/{userId}")
	public UserRating getUserRating(@PathVariable ("userId") String userId) {
		List<RatingData> ratings = Arrays.asList(
				new RatingData("1234", 4),
				new RatingData("8756", 3)
				);
		
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
