package movie.processor.model.movie

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import io.micronaut.core.annotation.Introspected
import movie.processor.model.movie.search.MovieSearchResult
import java.time.Instant
import java.time.ZoneId

@Introspected
data class Movies(val movies: List<Movie>)

@Introspected
@DynamoDBTable(tableName = "movies")
data class Movie(
        @DynamoDBRangeKey
        val title: String,
        val tmdbId: Int,
        val posterPath: String?,
        val overview: String,
        @DynamoDBHashKey(attributeName = "publishDate")
        val releaseDate: Instant,
        val originalTitle: String,
        val voteAverage: Double)

internal fun MovieSearchResult.toMovie() =
        Movie(this.title,
                this.id,
                this.posterPath,
                this.overview,
                this.releaseDate.atStartOfDay(ZoneId.systemDefault()).toInstant(),
                this.originalTitle,
                this.voteAverage)
