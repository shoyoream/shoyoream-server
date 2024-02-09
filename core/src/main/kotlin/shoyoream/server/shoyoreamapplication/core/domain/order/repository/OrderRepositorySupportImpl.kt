package shoyoream.server.shoyoreamapplication.core.domain.order.repository

import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import org.springframework.stereotype.Component

@Component
class OrderRepositorySupportImpl(
    private val queryFactory: SpringDataQueryFactory
) : OrderRepositorySupport
