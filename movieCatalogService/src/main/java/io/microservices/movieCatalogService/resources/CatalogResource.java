package io.microservices.movieCatalogService.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.microservices.movieCatalogService.models.CatalogItem;
import io.microservices.movieCatalogService.models.UserRating;
import io.microservices.movieCatalogService.services.MovieService;
import io.microservices.movieCatalogService.services.UserRatingService;;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
	
	@Autowired
	MovieService movieService;
	
	@Autowired 
	UserRatingService userRatingService;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")  String userId){

		UserRating userRating = userRatingService.getUserRating(userId);
		
	    return userRating.getUserRating().stream()
	    		.map(RatingData -> movieService.getMovieInfo(RatingData))
	    		.collect(Collectors.toList());

	}
}
