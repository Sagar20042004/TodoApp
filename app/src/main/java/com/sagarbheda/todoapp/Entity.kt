package com.sagarbheda.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "To_do")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority:String
    )
{
}