package com.sagarbheda.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_task.create_priority
import kotlinx.android.synthetic.main.activity_update_task.create_title
import kotlinx.android.synthetic.main.activity_update_task.delete_button
import kotlinx.android.synthetic.main.activity_update_task.update_button
import kotlinx.android.synthetic.main.each_rv.view.priority
import kotlinx.android.synthetic.main.each_rv.view.title

class Activity_update_task : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_task)

        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val title = DataObject.getData(pos).title
            val priority = DataObject.getData(pos).priority

            create_title.setText(title)
            create_priority.setText(priority)


            delete_button.setOnClickListener {
                DataObject.deleteData(pos)
                myIntent()
            }

            update_button.setOnClickListener {
                DataObject.updateData(
                    pos,
                    create_title.text.toString(),
                    create_priority.text.toString()
                )
                Toast.makeText(this,title+" "+priority,Toast.LENGTH_LONG).show()
                myIntent()
            }
        }
    }

    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}