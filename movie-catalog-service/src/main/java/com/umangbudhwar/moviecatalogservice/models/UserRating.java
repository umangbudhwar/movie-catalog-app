/**
 * 
 */
package com.umangbudhwar.moviecatalogservice.models;

import java.util.List;

/**
 * @author Umang Budhwar
 *
 */
public class UserRating {

	private String userId;
	private List<Rating> userRating;

	public UserRating() {

	}

	/**
	 * @param userId
	 * @param userRating
	 */
	public UserRating(String userId, List<Rating> userRating) {
		super();
		this.userId = userId;
		this.userRating = userRating;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userRating
	 */
	public List<Rating> getUserRating() {
		return userRating;
	}

	/**
	 * @param userRating the userRating to set
	 */
	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

}
