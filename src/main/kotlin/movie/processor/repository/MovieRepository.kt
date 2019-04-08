package movie.processor.repository

import com.agorapulse.micronaut.aws.dynamodb.annotation.Service
import movie.processor.model.movie.Movie

@Service(Movie::class)
interface MovieRepository {

    fun saveAll(movies: List<Movie>): List<Movie>
}
