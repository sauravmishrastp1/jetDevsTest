package com.imaginato.homeworkmvvm

object LoginUtils {

    fun validate(username: String, password: String): String? {
        if (username.isEmpty()) return "please enter username"


        if(password.isEmpty()) return "please enter password"

        return null

    }

}