package shoyoream.server.shoyoreamapplication.core.infra.http.config

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import java.time.Duration
import java.util.concurrent.TimeUnit
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient

abstract class WebClientConfig {
    companion object {
        private const val TIME_OUT_MS = 30000L
    }

    open fun createWebClient(baseUrl: String, readTimeout: Long, connectTimeout: Long): WebClient {
        val httpClient: HttpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeout.toInt())
            .responseTimeout(Duration.ofMillis(TIME_OUT_MS))
            .doOnConnected {
                it
                    .addHandlerLast(ReadTimeoutHandler(readTimeout.toLong(), TimeUnit.MILLISECONDS))
                    .addHandlerLast(WriteTimeoutHandler(TIME_OUT_MS, TimeUnit.MILLISECONDS))
            }

        val exchangeStrategies = ExchangeStrategies.builder()
            .codecs { configurer -> configurer.defaultCodecs().maxInMemorySize(-1) }
            .build()

        return WebClient.builder()
            .baseUrl(baseUrl)
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .exchangeStrategies(exchangeStrategies)
            .build()
    }
}
