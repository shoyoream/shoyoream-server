package shoyoream.server.shoyoreamapplication.core.domain.product.goods.repository

import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.singleQuery
import java.util.*
import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.Goods

@Component
class GoodsRepositorySupportImpl(
    private val queryFactory: SpringDataQueryFactory
) : GoodsRepositorySupport {
    override fun findGoodsByGoodsId(id: UUID): Goods? {
        return queryFactory.singleQuery {
            select(entity(Goods::class))
            from(entity(Goods::class))
            where(col(Goods::id).equal(id))
        }
    }
}
