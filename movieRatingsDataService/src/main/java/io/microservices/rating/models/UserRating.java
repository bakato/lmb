package io.microservices.rating.models;

import java.util.List;

public class UserRating {
	
	private List<RatingData> userRatings;

	public List<RatingData> getUserRating() {
		return userRatings;
	}

	public void setUserRating(List<RatingData> userRating) {
		this.userRatings = userRating;
	}
	

}
