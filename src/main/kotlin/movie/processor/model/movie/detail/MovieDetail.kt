package movie.processor.model.movie.detail

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDate

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class MovieDetail(val originalLanguage: String,
                       val imdbId: String?,
                       val title: String,
                       val backdropPath: String?,
                       val genres: Set<Genre>,
                       val id: Long,
                       val voteCount: Int,
                       val overview: String?,
                       val originalTitle: String,
                       val runtime: Int?,
                       val posterPath: String?,
                       val releaseDate: LocalDate,
                       val voteAverage: Double,
                       val tagline: String?,
                       val status: String,
                       val videos: Videos,
                       val images: Images)
