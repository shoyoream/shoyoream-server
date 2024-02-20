package shoyoream.server.shoyoreamapplication.core.domain.product.goods.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.Goods
import java.util.UUID

@GraphQlRepository
interface GoodsRepository : JpaRepository<Goods, UUID>, KotlinJdslJpqlExecutor
