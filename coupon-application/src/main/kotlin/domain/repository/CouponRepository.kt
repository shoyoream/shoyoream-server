package commerce.eda.domain.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import commerce.eda.domain.entity.Coupon
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CouponRepository : JpaRepository<Coupon, UUID>, KotlinJdslJpqlExecutor
