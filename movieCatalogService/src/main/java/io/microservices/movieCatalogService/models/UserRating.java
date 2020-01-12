package io.microservices.movieCatalogService.models;

import java.util.List;

public class UserRating {
	
	private List<RatingData> userRating;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<RatingData> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<RatingData> userRating) {
		this.userRating = userRating;
	}
	

}
