package movie.processor

import com.amazonaws.services.lambda.runtime.events.SQSEvent
import io.micronaut.function.client.FunctionClient
import io.micronaut.http.annotation.Body
import io.reactivex.Single
import movie.processor.model.RssFeeds
import movie.processor.service.MovieProcessor
import javax.inject.Named

@FunctionClient
interface MovieProcessorClient {

    @Named("movie-processor")
    fun apply(@Body body : SQSEvent): Single<RssFeeds>

}
