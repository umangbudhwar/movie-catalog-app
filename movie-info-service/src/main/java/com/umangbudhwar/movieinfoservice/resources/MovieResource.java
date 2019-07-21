/**
 * 
 */
package com.umangbudhwar.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.umangbudhwar.movieinfoservice.models.Movie;
import com.umangbudhwar.movieinfoservice.models.MovieSummary;

/**
 * @author Umang Budhwar
 *
 */

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("${api.key}")
	private String apiKey;

	//@Autowired
	//private RestTemplate restTemplate;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		RestTemplate restTemplate = new RestTemplate();
		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}
}
