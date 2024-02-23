package domain.mapper

interface BaseMapper<From, To>{
    suspend fun map(from: From): To
}