package com.iushin.data.clientIntrfaces

interface GetCurrentUserNameClient {
    suspend fun getName(): String?
}