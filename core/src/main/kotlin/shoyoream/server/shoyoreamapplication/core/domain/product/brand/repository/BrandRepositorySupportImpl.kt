package shoyoream.server.shoyoreamapplication.core.domain.product.brand.repository

import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import java.util.*
import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.core.domain.product.brand.entity.Brand

@Component
class BrandRepositorySupportImpl(
    private val queryFactory: SpringDataQueryFactory
) : BrandRepositorySupport {
    override fun findBrandByBrandId(id: UUID): Brand? {
        return queryFactory.listQuery<Brand> {
            select(entity(Brand::class))
            from(entity(Brand::class))
            where(col(Brand::id).equal(id))
        }.firstOrNull()
    }

    override fun findBrandByBrandName(brandName: String): Brand? {
        return queryFactory.listQuery<Brand> {
            select(entity(Brand::class))
            from(entity(Brand::class))
            where(col(Brand::brandName).equal(brandName))
        }.firstOrNull()
    }
}
