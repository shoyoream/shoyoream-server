package shoyoream.server.shoyoreamapplication.core.infra.`kotlin-jdsl`

import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.querydsl.SpringDataCriteriaQueryDsl

inline fun <reified T> SpringDataQueryFactory.singleNullableQuery(
    noinline dsl: SpringDataCriteriaQueryDsl<T>.() -> Unit
): T? = selectQuery(T::class.java, dsl).resultList.firstOrNull()
