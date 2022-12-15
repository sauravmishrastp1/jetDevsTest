package com.imaginato.homeworkmvvm.data.remote.demo

import com.imaginato.homeworkmvvm.data.remote.demo.response.Data
import com.imaginato.homeworkmvvm.data.remote.demo.response.LoginResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface DemoRepository {

    suspend fun getDemoData(): Flow<String>
    suspend fun login(userName:String,password:String): LoginResponse
}