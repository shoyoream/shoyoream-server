package shoyoream.server.shoyoreamapplication.core.common.utils

import shoyoream.server.shoyoreamapplication.core.common.enumeration.TimeRegion
import java.time.LocalDateTime
import java.time.ZoneId

object TimeGenerator {
    fun returnTimeNow(): LocalDateTime {
        return LocalDateTime.now(ZoneId.of(TimeRegion.ASIA_SEOUL.region))
    }
}
