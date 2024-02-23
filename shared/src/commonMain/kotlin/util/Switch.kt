package util

data class Switch<T>(private var input: T, private val initialValue: T) {
    val value: T
        get() {
            val t = input
            input = initialValue
            return t
        }

    fun peek(): T {
        return value
    }
}