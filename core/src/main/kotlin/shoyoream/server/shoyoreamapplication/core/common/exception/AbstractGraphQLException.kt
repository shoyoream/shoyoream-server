package shoyoream.server.shoyoreamapplication.core.common.exception

class AbstractGraphQLException : RuntimeException {
    private var parameters: MutableMap<String, Any> = HashMap()

    constructor(message: String) : super(message)

    constructor(message: String, additionParams: Map<String, Any>?) : this(message) {
        additionParams?.let { parameters = HashMap(it) }
    }

    fun getExtensions(): Map<String, Any> {
        return parameters.entries.associate { it.key to it.value }
    }
}
