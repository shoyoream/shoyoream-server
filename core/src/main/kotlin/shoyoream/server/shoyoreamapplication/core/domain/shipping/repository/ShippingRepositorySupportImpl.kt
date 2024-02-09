package shoyoream.server.shoyoreamapplication.core.domain.shipping.repository

import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import org.springframework.stereotype.Component

@Component
class ShippingRepositorySupportImpl(
    private val queryFactory: SpringDataQueryFactory
) : ShippingRepositorySupport
