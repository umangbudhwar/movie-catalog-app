/**
 * 
 */
package com.umangbudhwar.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.umangbudhwar.moviecatalogservice.models.CatalogItem;
import com.umangbudhwar.moviecatalogservice.models.Movie;
import com.umangbudhwar.moviecatalogservice.models.Rating;

/**
 * @author Umang Budhwar
 *
 */
@Service
public class MovieInfo {

	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * @param rating
	 * @return
	 */
	@HystrixCommand(
			fallbackMethod = "getFallbackCatalogItem", 
			threadPoolKey = "movieInfoPool",
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "20"),
					@HystrixProperty(name = "maxQueueSize", value = "10")
			})
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
	}
	
	public CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("Movie Name not found.", "", rating.getRating());
	}
}
