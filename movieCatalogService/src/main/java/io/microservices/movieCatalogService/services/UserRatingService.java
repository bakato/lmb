package io.microservices.movieCatalogService.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.microservices.movieCatalogService.models.RatingData;
import io.microservices.movieCatalogService.models.UserRating;

@Service
public class UserRatingService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRaging")
	public UserRating getUserRating(@PathVariable("userId")  String userId) {
		return restTemplate.getForObject("http://movieRatingsDataService/rating/users/" + userId, UserRating.class);
	}
	
	public UserRating getFallbackUserRaging(@PathVariable("userId")  String userId){
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);;
		userRating.setUserRating(Arrays.asList(
				new RatingData("0", 0)
				
	        ));
		
	   return userRating;
	}

}