package util

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

object DateAndTime {

    fun  getCurrentTimeMillis() = Clock.System.now().toEpochMilliseconds()
    fun getCurrentDateTime() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

    fun getSecond() = getCurrentDateTime().second
    fun getMinute() = getCurrentDateTime().minute
    fun getHour() = getCurrentDateTime().hour

}

object DateAndTimeFromMillis {
    fun getSecondFromEpochMilliseconds(epochMilliseconds: Long) =
        Instant.fromEpochMilliseconds(epochMilliseconds)
            .toLocalDateTime(TimeZone.currentSystemDefault()).second

    fun getMinuteFromEpochMilliseconds(epochMilliseconds: Long) =
        Instant.fromEpochMilliseconds(epochMilliseconds)
            .toLocalDateTime(TimeZone.currentSystemDefault()).minute

    fun getHourFromEpochMilliseconds(epochMilliseconds: Long) =
        Instant.fromEpochMilliseconds(epochMilliseconds)
            .toLocalDateTime(TimeZone.currentSystemDefault()).hour

}