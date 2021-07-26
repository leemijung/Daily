package com.example.main.todo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 2)
abstract class Appdatabase : RoomDatabase(){
    abstract fun todoDao(): TodoDao
}