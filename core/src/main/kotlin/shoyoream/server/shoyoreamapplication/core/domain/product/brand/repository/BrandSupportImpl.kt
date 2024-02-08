package shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository

import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.singleQuery
import java.util.*
import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand

@Component
class BrandSupportImpl(
    private val queryFactory: SpringDataQueryFactory
) : BrandSupport {
    override fun findBrandByBrandId(id: UUID): Brand? {
        return queryFactory.singleQuery {
            select(entity(Brand::class))
            from(entity(Brand::class))
            where(col(Brand::id).equal(id))
        }
    }
}
