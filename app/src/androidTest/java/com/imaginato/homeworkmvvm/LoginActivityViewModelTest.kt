package com.imaginato.homeworkmvvm

import com.imaginato.homeworkmvvm.ui.login.LoginActivityViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test

class LoginActivityViewModelTest {
    private val viewModel = LoginActivityViewModel()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun username_is_empty() {
        val username = ""
        val assert = viewModel.validateFeildsForTest(username, "123456")
        assert(assert == true)
    }

    @Test
    fun password_is_empty() {
        val password = ""
        val assert = viewModel.validateFeildsForTest("username", password)
        assert(assert == true)
    }





}

