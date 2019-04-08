package movie.processor.client

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import movie.processor.model.movie.detail.MovieDetail
import movie.processor.model.movie.search.MovieSearch

@Client("\${tmdb.base-url}")
interface MovieDataProvider {

    @Get("/search/movie")
    fun searchForMovie(@QueryValue("api_key") apiKey: String,
                       @QueryValue("query") query: String,
                       @QueryValue("primary_release_year") primaryReleaseYear: Int,
                       @QueryValue("language") language: String = "en-US"): MovieSearch

    @Get("/movie/{movieId}")
    fun getMovieDetails(@PathVariable("movieId") movieId: Long,
                        @QueryValue("api_key") apiKey: String,
                        @QueryValue("language") language: String,
                        @QueryValue("include_image_language") imageLang: String,
                        @QueryValue("append_to_response") appendToResponse: String = "videos,images"): MovieDetail
}
