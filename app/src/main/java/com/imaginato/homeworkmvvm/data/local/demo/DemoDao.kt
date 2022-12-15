package com.imaginato.homeworkmvvm.data.local.demo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.imaginato.homeworkmvvm.data.remote.demo.response.Data

@Dao
interface DemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDemo(demo: Demo)
}