package movie.processor.model.movie.search

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(SnakeCaseStrategy::class)
data class MovieSearch(val page: Int,
                       val totalPages: Int,
                       val results: List<MovieSearchResult>,
                       val totalResults: Int)
