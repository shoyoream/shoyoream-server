package shoyoream.server.shoyoreamapplication.core.domain.brand.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class BrandSupportImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : BrandSupport
