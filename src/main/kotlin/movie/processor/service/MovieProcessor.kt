package movie.processor.service

import com.amazonaws.services.lambda.runtime.events.SQSEvent
import com.fasterxml.jackson.databind.ObjectMapper
import movie.processor.model.RssFeed
import javax.inject.Singleton

@Singleton
class MovieProcessor(private val objectMapper: ObjectMapper) {

    fun readFromQueue(sqsEvent: SQSEvent): List<RssFeed> {
        return sqsEvent.records.mapNotNull { objectMapper.readValue(it.body, RssFeed::class.java) }
    }
}
