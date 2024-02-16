package shoyoream.server.shoyoreamapplication.core.domain.product.goods.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.Goods
import java.util.UUID

@GraphQlRepository
interface GoodsRepository : JpaRepository<Goods, UUID>, GoodsRepositorySupport
