package shoyoream.server.shoyoreamapplication.core.domain.payment.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository
import shoyoream.server.shoyoreamapplication.core.domain.payment.entity.EasyPayMethod

interface EasyPayMethodRepository : JpaRepository<EasyPayMethod, Long>, KotlinJdslJpqlExecutor
