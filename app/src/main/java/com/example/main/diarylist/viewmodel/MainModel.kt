package com.example.main.diarylist.viewmodel


import com.example.main.diarylist.DiaryActivity2
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.main.R
import com.example.main.diarylist.DiarySubActivity2

class MainModel(private var activity : AppCompatActivity, private var context: Context) : ViewModel {


    override fun onCreate() {

    }

    fun clickEvent(view : View) {

        when(view.id) {

            R.id.addNewTodoFab -> {
                activity.startActivity(Intent(context, DiarySubActivity2::class.java))
                activity.finish()
            }

        }

    }

}

