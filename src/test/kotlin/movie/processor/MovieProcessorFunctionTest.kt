package movie.processor

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it


class MovieProcessorFunctionTest : Spek({

    describe("movie-processor function") {
        val server = ApplicationContext.run(EmbeddedServer::class.java)
        val client = server.applicationContext.getBean(MovieProcessorClient::class.java)

        it("should return 'movie-processor'") {
        }

        afterGroup {
            server.stop()
        }
    }
})
