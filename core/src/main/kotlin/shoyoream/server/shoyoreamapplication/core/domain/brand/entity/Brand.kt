package shoyoream.server.shoyoreamapplication.core.domain.brand.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity
import shoyoream.server.shoyoreamapplication.core.common.utils.UUIDGenerator
import shoyoream.server.shoyoreamapplication.core.domain.product.entity.Product

@Entity
@Table(name = "brands")
class Brand(
    @Id
    @Column(name = "products_id", columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    val id: UUID = UUIDGenerator.randomUUID(),

    @OneToMany(mappedBy = "brand")
    val products: MutableList<Product> = mutableListOf()
) : BaseTimeEntity()
