package se.magictechnology.pia9v6monvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var mainviewmodel : MainViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainviewmodel = ViewModelProvider(this).get(MainViewmodel::class.java)

        val todoET = findViewById<EditText>(R.id.todoEdittext)
        val addButton = findViewById<Button>(R.id.addButton)
        val todoRV = findViewById<RecyclerView>(R.id.todoRV)
        val clearButton = findViewById<Button>(R.id.clearButton)

        addButton.setOnClickListener {
            val todoText = todoET.text.toString()

            mainviewmodel.addTodo(todoText)

        }

        clearButton.setOnClickListener {
            mainviewmodel.clearTodo()
        }

        mainviewmodel.getTodoList().observe(this, { thetodostrings ->
            Log.d("pia9debug", "*** TODO ***")
            for(todo in thetodostrings)
            {
                Log.d("pia9debug", todo)
            }
        })



    }



}