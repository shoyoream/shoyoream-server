package shoyoream.server.shoyoreamapplication.core.domain.product.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.ConstraintMode
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import shoyoream.server.shoyoreamapplication.core.common.model.BaseTimeEntity
import shoyoream.server.shoyoreamapplication.core.common.utils.UUIDGenerator
import java.util.UUID
import shoyoream.server.shoyoreamapplication.core.domain.brand.entity.Brand

@Entity
@Table(name = "products")
class Product(
    @Id
    @Column(name = "products_id", columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    val id: UUID = UUIDGenerator.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brands_id", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    val brand: Brand
) : BaseTimeEntity()
