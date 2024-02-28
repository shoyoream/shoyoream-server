package shoyoream.server.shoyoreamapplication.core.common.exception

import graphql.GraphQLError
import graphql.GraphqlErrorBuilder
import graphql.schema.DataFetchingEnvironment
import org.springframework.graphql.execution.ErrorType
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter
import org.springframework.stereotype.Component

@Component
class CustomExceptionResolver : DataFetcherExceptionResolverAdapter() {

    override fun resolveToSingleError(ex: Throwable, env: DataFetchingEnvironment): GraphQLError? {
        return when (ex) {
            is InvalidRequestException -> GraphqlErrorBuilder.newError()
                .errorType(ErrorType.BAD_REQUEST)
                .message(ex.errorType.getErrorType())
                .path(env.executionStepInfo.path)
                .location(env.field.sourceLocation)
                .build()
            is UnauthorizedException -> GraphqlErrorBuilder.newError()
                .errorType(ErrorType.UNAUTHORIZED)
                .message(ex.errorType.getErrorType())
                .path(env.executionStepInfo.path)
                .location(env.field.sourceLocation)
                .build()
            is DataNotFoundException -> GraphqlErrorBuilder.newError()
                .errorType(ErrorType.NOT_FOUND)
                .message(ex.errorType.getErrorType())
                .path(env.executionStepInfo.path)
                .location(env.field.sourceLocation)
                .build()
            is NotAllowedException -> GraphqlErrorBuilder.newError()
                .errorType(ErrorType.FORBIDDEN)
                .message(ex.errorType.getErrorType())
                .path(env.executionStepInfo.path)
                .location(env.field.sourceLocation)
                .build()
            is AbstractGraphQLException -> GraphqlErrorBuilder.newError()
                .errorType(ErrorType.INTERNAL_ERROR)
                .message(ex.message)
                .path(env.executionStepInfo.path)
                .location(env.field.sourceLocation)
                .extensions(ex.getExtensions())
                .build()
            else -> null
        }
    }
}
