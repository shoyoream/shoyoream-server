package shoyoream.server.shoyoreamapplication.core.common.aop.annotation

import java.util.concurrent.TimeUnit

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class DistributedLock(
    val key: String,

    val timeUnit: TimeUnit = TimeUnit.SECONDS,

    val waitTime: Long = 5L,

    val leaseTime: Long = 3L
)
