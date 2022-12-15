package com.imaginato.homeworkmvvm.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.imaginato.homeworkmvvm.data.local.demo.Demo
import com.imaginato.homeworkmvvm.data.local.demo.DemoDatabase
import com.imaginato.homeworkmvvm.data.remote.demo.DemoRepository
import com.imaginato.homeworkmvvm.data.remote.demo.response.LoginResponse
import com.imaginato.homeworkmvvm.exts.ENTER_PASSWORD
import com.imaginato.homeworkmvvm.exts.ENTER_USER_NAME
import com.imaginato.homeworkmvvm.exts.errorCode
import com.imaginato.homeworkmvvm.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.inject

@KoinApiExtension
class LoginActivityViewModel : BaseViewModel() {
    private val repository: DemoRepository by inject()
    private var _progress: MutableLiveData<Boolean> = MutableLiveData()
    private var _loginRetrofitResponse :MutableLiveData<retrofit2.Response<LoginResponse>> = MutableLiveData()
    private var _loginResponse :MutableLiveData<LoginResponse> = MutableLiveData()
    private var _errorMessage :MutableLiveData<String> = MutableLiveData()
    private val database: DemoDatabase by inject()

    val progress: LiveData<Boolean>
        get() {
            return _progress
        }


    val loginResponseResult :LiveData<LoginResponse>
    get(){
        return _loginResponse
    }


    val errorMessage :LiveData<String>
        get(){
            return _errorMessage
        }
    fun validateFeilds(userName:String,password:String):Boolean {
         if(userName.isEmpty()){
            _errorMessage.value = ENTER_USER_NAME
            return  false
        }else if(password.isEmpty()){
            _errorMessage.value =ENTER_PASSWORD

           return false
        }else{
            login(userName,password)
            return  true
        }
    }



    /**
     * Do something and handle business logic here
     * */

    fun login(userName:String,password:String) {
        viewModelScope.launch {
            repository.login(userName,password)
                .onStart {
                    _progress.value = true

                }.catch {
                    _progress.value = true

                }
                .onCompletion {
                    _progress.value = true

                }.collect {
                    _progress.value = false
                    _loginRetrofitResponse.value = it
                    _loginResponse.value = _loginRetrofitResponse.value!!.body()
                    if(_loginResponse.value!!.errorCode==errorCode.errorCode00.code){
                        database.demoDao.insertDemo( Demo(
                            loginResponseResult.value!!.data.userId,
                            _loginRetrofitResponse.value!!.headers()["X-Acc"]!!,
                            loginResponseResult.value!!.data.userId,
                            loginResponseResult.value!!.data.userName,
                            loginResponseResult.value!!.data.isDeleted
                        ))
                    }



                }



        }
    }

    fun validateFeildsForTest(userName:String,password:String):Boolean {
        return if(userName.isEmpty()){
            true
        }else password.isEmpty()
    }
}