package com.imaginato.homeworkmvvm.data.local.demo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Demo")
data class Demo(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "userId") var userId: String,
    @ColumnInfo(name = "xAcc") var xAcc: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "isDeleted") var isDeleted: Boolean

)