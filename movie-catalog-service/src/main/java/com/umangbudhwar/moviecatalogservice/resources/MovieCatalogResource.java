/**
 * 
 */
package com.umangbudhwar.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.umangbudhwar.moviecatalogservice.models.CatalogItem;
import com.umangbudhwar.moviecatalogservice.models.UserRating;
import com.umangbudhwar.moviecatalogservice.services.MovieInfo;
import com.umangbudhwar.moviecatalogservice.services.UserRatingInfo;

/**
 * @author Umang Budhwar
 *
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRatings = userRatingInfo.getUserRating(userId);

		return userRatings.getUserRating().stream().map(rating -> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
	}

}
