package movie.processor.model

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime

@Introspected
data class RssFeeds(val feeds: List<RssFeed>)

@Introspected
data class RssFeed(
        val title: String,
        val description: String,
        val link: String,
        val publishedDate: LocalDateTime)
