package io.microservices.movieCatalogService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.microservices.movieCatalogService.models.CatalogItem;
import io.microservices.movieCatalogService.models.MovieInfo;
import io.microservices.movieCatalogService.models.RatingData;

@Service
public class MovieService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackMovie")
	public CatalogItem getMovieInfo(RatingData rating) {
		MovieInfo movie = restTemplate.getForObject("http://movieInfoService/movie/" + rating.getMovieId(), MovieInfo.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}
	
	public CatalogItem getFallbackMovie(RatingData rating){
		return new CatalogItem("No Name", "No desc", 0);
	}

}
