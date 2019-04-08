package movie.processor.model.movie.search

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDate

@JsonNaming(SnakeCaseStrategy::class)
data class MovieSearchResult(val id: Int,
                             val originalTitle: String,
                             val title: String,
                             val releaseDate: LocalDate,
                             val voteAverage: Double,
                             val voteCount: Int,
                             val posterPath: String?,
                             val backdropPath: String?,
                             val overview: String)
