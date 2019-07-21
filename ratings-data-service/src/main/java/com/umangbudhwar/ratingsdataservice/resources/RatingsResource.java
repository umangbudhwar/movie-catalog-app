/**
 * 
 */
package com.umangbudhwar.ratingsdataservice.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umangbudhwar.ratingsdataservice.models.Rating;
import com.umangbudhwar.ratingsdataservice.models.UserRating;

/**
 * @author Umang Budhwar
 *
 */
@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
    
    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserRating(Arrays.asList(new Rating("100", 4), new Rating("200", 3)));
        return userRating;
    }
}