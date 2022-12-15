package com.imaginato.homeworkmvvm.data.remote.demo

import com.imaginato.homeworkmvvm.data.remote.demo.response.Data
import com.imaginato.homeworkmvvm.data.remote.demo.response.LoginResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DemoDataRepository constructor(
    private var api: DemoApi
) : DemoRepository {
    companion object {
        private const val URL_GET_PUBLIC_IP = "https://ifconfig.me/all.json"
        private const val NOTHING_GET = "Nothing get!"
        private const val  URL_LOGIN ="http://private-222d3-homework5.apiary-mock.com/api/login"
    }

    override suspend fun getDemoData() = flow {
        val response = api.getDemoDataAsync(URL_GET_PUBLIC_IP).await()
        emit(response.ipAddress ?: NOTHING_GET)
    }.flowOn(Dispatchers.IO)

    override suspend fun login(userName:String,password:String):LoginResponse{
        val parameter:HashMap<String,Any> = hashMapOf()
        parameter["username"] =userName
        parameter["password"] =password
        val response = api.loginApi(URL_LOGIN,parameter).await()
        return response

    }




}