package movie.processor

import com.amazonaws.services.lambda.runtime.events.SQSEvent
import io.micronaut.function.FunctionBean
import io.micronaut.function.executor.FunctionInitializer
import movie.processor.model.RssFeeds
import movie.processor.service.MovieProcessor
import java.util.function.Function
import javax.inject.Inject

@FunctionBean("movie-processor")
class MovieProcessorFunction : FunctionInitializer(), Function<SQSEvent, RssFeeds> {

    @Inject
    private lateinit var movieProcessor: MovieProcessor

    override fun apply(msg: SQSEvent): RssFeeds {
        val feeds = movieProcessor.readFromQueue(msg)
        return RssFeeds(feeds)
    }
}
