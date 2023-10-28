package com.sagarbheda.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_card.editText_priority
import kotlinx.android.synthetic.main.activity_create_card.editText_task
import kotlinx.android.synthetic.main.activity_create_card.save_button

class Activity_create_card : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)

        save_button.setOnClickListener {
            if (editText_task.text.toString().trim{it<=' '}.isNotEmpty() && editText_priority.text.toString().trim{it<=' '}.isNotEmpty()){
                val title = editText_task.getText().toString()
                val priority = editText_priority.getText().toString()
                DataObject.setData(title  ,priority)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
        }

    }
}