package shoyoream.server.shoyoreamapplication.core.domain.product.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class ProductSupportImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : ProductSupport
