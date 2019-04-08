package movie.processor.service

import com.amazonaws.services.lambda.runtime.events.SQSEvent
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.context.annotation.Property
import movie.processor.client.MovieDataProvider
import movie.processor.model.RssFeed
import movie.processor.model.movie.Movie
import movie.processor.model.movie.toMovie
import movie.processor.repository.MovieRepository
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Singleton

@Singleton
class MovieProcessor(private val objectMapper: ObjectMapper,
                     private val movieDataProvider: MovieDataProvider,
                     private val movieRepository: MovieRepository,
                     @Property(name = "tmdb.api-key") private val apiKey: String) {

    fun readFromQueue(sqsEvent: SQSEvent): List<Movie> {
        val rssFeeds = sqsEvent.records.mapNotNull { objectMapper.readValue(it.body, RssFeed::class.java) }
        val movies = rssFeeds
                .map { movieDataProvider.searchForMovie(apiKey, it.title, it.publishedDate.year()) }
                .map { movieSearch -> movieSearch.results.first().toMovie() }
        return movieRepository.saveAll(movies)
    }
}

private fun Instant.year(): Int = LocalDateTime.ofInstant(this, ZoneOffset.UTC).year
