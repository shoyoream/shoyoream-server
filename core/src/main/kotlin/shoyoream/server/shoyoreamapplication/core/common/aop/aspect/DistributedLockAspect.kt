package shoyoream.server.shoyoreamapplication.core.common.aop.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Component
import shoyoream.server.shoyoreamapplication.core.common.aop.annotation.DistributedLock
import shoyoream.server.shoyoreamapplication.core.common.utils.CustomExpressionLanguageParser

@Aspect
@Component
class DistributedLockAspect(
    private val redissonClient: RedissonClient,
    private val aopForTransaction: AopForTransaction
) {
    companion object {
        private const val REDISSON_LOCK_PREFIX = "lock:"
    }

    @Around("@annotation(shoyoream.server.shoyoreamapplication.core.common.aop.annotation.DistributedLock)")
    fun lock(joinPoint: ProceedingJoinPoint): Any {
        val signature = joinPoint.signature as MethodSignature
        val method = signature.method
        val distributedLock = method.getAnnotation(DistributedLock::class.java)

        val key = REDISSON_LOCK_PREFIX + CustomExpressionLanguageParser.getDynamicValue(
            signature.parameterNames,
            joinPoint.args,
            distributedLock.key
        )
        val rLock = redissonClient.getLock(key)

        try {
            val available = rLock.tryLock(distributedLock.waitTime, distributedLock.leaseTime, distributedLock.timeUnit)

            if (!available) {
                return false
            }

            return aopForTransaction.proceed(joinPoint)
        } catch (e: InterruptedException) {
            throw e
        } finally {
            try {
                rLock.unlock()
            } catch (e: IllegalMonitorStateException) {
                throw e
            }
        }
    }
}
