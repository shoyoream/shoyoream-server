package shoyoream.server.shoyoreamapplication.domain.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.domain.entity.Order

@GraphQlRepository
interface OrderRepository : JpaRepository<Order, UUID>, KotlinJdslJpqlExecutor {
    fun countOrdersByStocksId(stocksId: UUID): Long
}
