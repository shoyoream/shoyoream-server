package shoyoream.server.shoyoreamapplication.core.domain.payment.repository

import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import org.springframework.stereotype.Component

@Component
class PaymentRepositorySupportImpl(
    private val queryFactory: SpringDataQueryFactory
) : PaymentRepositorySupport
