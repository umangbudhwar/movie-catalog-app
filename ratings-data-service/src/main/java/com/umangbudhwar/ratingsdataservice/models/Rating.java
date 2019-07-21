/**
 * 
 */
package com.umangbudhwar.ratingsdataservice.models;

/**
 * @author Umang Budhwar
 *
 */
public class Rating {

	private String movieId;
	private int rating;

	/**
	 * @param movieId
	 * @param rating
	 */
	public Rating(String movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

}
