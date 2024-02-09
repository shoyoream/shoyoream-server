package shoyoream.server.shoyoreamapplication.core.domain.product.goods.repository

import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.entity.Goods
import java.util.UUID

interface GoodsRepositoryRepository : JpaRepository<Goods, UUID>, GoodsRepositorySupport
