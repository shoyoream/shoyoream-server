package shoyoream.server.shoyoreamapplication.core.domain.product.goods.service

import org.springframework.stereotype.Service
import shoyoream.server.shoyoreamapplication.core.domain.product.goods.repository.GoodsRepository

@Service
class GoodsSelectionService(
    private val goodsRepository: GoodsRepository
)
