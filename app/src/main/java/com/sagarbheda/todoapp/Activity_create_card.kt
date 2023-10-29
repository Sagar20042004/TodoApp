package com.sagarbheda.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.editText_priority
import kotlinx.android.synthetic.main.activity_create_card.editText_task
import kotlinx.android.synthetic.main.activity_create_card.save_button
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Activity_create_card : AppCompatActivity() {

    //for database
    private lateinit var database:myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)

        //database calss object create
        database = Room.databaseBuilder(
            applicationContext,myDatabase::class.java,"To_Do"
        ).build()

        save_button.setOnClickListener {
            if (editText_task.text.toString().trim{it<=' '}.isNotEmpty() && editText_priority.text.toString().trim{it<=' '}.isNotEmpty()){
                val title = editText_task.getText().toString()
                val priority = editText_priority.getText().toString()
                DataObject.setData(title  ,priority)

                //aapno DAO na function suspend hoavthi aa background ma chale che to eema mate GlobalScope no use kareloo
                GlobalScope.launch {
                    database.dao().insertTask(Entity(0,title,priority))
                }

                //check karva mate ke data add thay cheke naii
                GlobalScope.launch {
                   Log.i("sagar" , database.dao().getTask().toString())
                }


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
        }

    }
}