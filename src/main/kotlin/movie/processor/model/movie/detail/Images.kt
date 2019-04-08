package movie.processor.model.movie.detail

import com.fasterxml.jackson.annotation.JsonAlias

data class Images(val backdrops: Set<Image>, val posters: Set<Image>)

data class Image(@JsonAlias("file_path")
                 val path: String,
                 val height: Int,
                 val width: Int,
                 @JsonAlias("iso_639_1")
                 val language: String?)
