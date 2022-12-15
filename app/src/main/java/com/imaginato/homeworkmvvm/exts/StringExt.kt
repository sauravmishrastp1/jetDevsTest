package com.imaginato.homeworkmvvm.exts
import timber.log.Timber

// Extensions for String
const val LOG_TYPE_REQUEST = "log request:"
const val LOG_TYPE_RESPONSE = "log response:"
const val LOG_TYPE_ERROR = "log error:"
const val LOG_TYPE_INFO = "log info:"
const val USERNAME_KEY ="username"
const val PASSWORD_KEY ="username"
const val ENTER_USER_NAME ="Please enter username"
const val ENTER_PASSWORD ="Please enter password"


fun String.printLog(type: String, tag: String) {
    when (type) {
        LOG_TYPE_REQUEST -> Timber.i(tag, "$type $this")
        LOG_TYPE_RESPONSE -> Timber.i(tag, "$type $this")
        LOG_TYPE_ERROR -> Timber.e(tag, "$type $this")
    }
}
enum class errorCode(var code:String){
    errorCode00("00"),
    errorCode01("01"),

}