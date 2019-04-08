package movie.processor

import com.amazonaws.services.lambda.runtime.events.SQSEvent
import io.micronaut.function.FunctionBean
import io.micronaut.function.executor.FunctionInitializer
import movie.processor.model.movie.Movies
import movie.processor.service.MovieProcessor
import java.util.function.Function
import javax.inject.Inject

@FunctionBean("movie-processor")
class MovieProcessorFunction : FunctionInitializer(), Function<SQSEvent, Movies> {

    @Inject
    private lateinit var movieProcessor: MovieProcessor

    override fun apply(msg: SQSEvent): Movies {
        val movie = movieProcessor.readFromQueue(msg)
        return Movies(movie)
    }
}
