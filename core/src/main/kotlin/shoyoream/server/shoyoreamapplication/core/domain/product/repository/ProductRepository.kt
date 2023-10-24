package shoyoream.server.shoyoreamapplication.core.domain.product.repository

import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.product.entity.Product
import java.util.UUID

interface ProductRepository : JpaRepository<Product, UUID>
