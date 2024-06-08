package shoyoream.server.shoyoreamapplication.domain.brand.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.graphql.data.GraphQlRepository
import shoyoream.server.shoyoreamapplication.domain.brand.entity.Brand

@GraphQlRepository
interface BrandRepository : JpaRepository<Brand, UUID>, KotlinJdslJpqlExecutor
