package movie.processor.model.movie.detail

import com.fasterxml.jackson.annotation.JsonAlias

data class Videos(val results: Set<Video>)

data class Video(val id: String,
                 val key: String,
                 @JsonAlias("iso_639_1")
                 val language: String,
                 @JsonAlias("iso_3166_1")
                 val region: String,
                 val name: String,
                 val site: String,
                 val size: String,
                 val type: String)
