package shoyoream.server.shoyoreamapplication.core.common.utils

import java.util.Base64

object Base64UtilFunctions {
    fun encodeToString(str: String): String {
        return Base64.getEncoder().encodeToString(str.toByteArray())
    }
}
