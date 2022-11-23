package nbc.demo.partition

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder

@SpringBootApplication
class Application {

    @Bean
    fun someCustomProcessor(): (Message<String>) -> Message<String> =
        { message ->
            MessageBuilder
                .fromMessage(message)
                .setHeader("SOME_CUSTOM_HEADER", "some-custom-value")
                .build()
        }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
