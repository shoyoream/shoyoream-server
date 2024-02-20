package shoyoream.server.shoyoreamapplication.core.infra.extensions

import com.linecorp.kotlinjdsl.dsl.jpql.Jpql
import com.linecorp.kotlinjdsl.querymodel.jpql.JpqlQueryable
import com.linecorp.kotlinjdsl.querymodel.jpql.select.SelectQuery
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor

fun <T : Any> KotlinJdslJpqlExecutor.findNullableSingle(
    init: Jpql.() -> JpqlQueryable<SelectQuery<T>>
): T? {
    return findAll(init).firstOrNull()
}
