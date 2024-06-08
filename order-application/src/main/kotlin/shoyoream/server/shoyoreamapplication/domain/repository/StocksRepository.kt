package shoyoream.server.shoyoreamapplication.domain.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.domain.entity.Stocks

interface StocksRepository : JpaRepository<Stocks, UUID>, KotlinJdslJpqlExecutor
