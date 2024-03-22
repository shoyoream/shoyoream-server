package shoyoream.server.shoyoreamapplication.core.domain.order.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.order.entity.Stocks

interface StocksRepository : JpaRepository<Stocks, UUID>, KotlinJdslJpqlExecutor
