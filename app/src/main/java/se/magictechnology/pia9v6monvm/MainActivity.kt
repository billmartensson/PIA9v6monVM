package se.magictechnology.pia9v6monvm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var mainviewmodel : MainViewmodel

    var todoadapter = TodoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        //var prefs = getSharedPreferences("todo", Context.MODE_PRIVATE)

        var prefs = getPreferences(Context.MODE_PRIVATE)

        var prefs_editor = prefs.edit()
        prefs_editor.putString("fruit", "banan")
        prefs_editor.putString("amount", "7")
        prefs_editor.apply()

        var fruitname = prefs.getString("fruit", null)
        */

        mainviewmodel = ViewModelProvider(this).get(MainViewmodel::class.java)

        val todoET = findViewById<EditText>(R.id.todoEdittext)
        val addButton = findViewById<Button>(R.id.addButton)
        val todoRV = findViewById<RecyclerView>(R.id.todoRV)
        val clearButton = findViewById<Button>(R.id.clearButton)

        todoRV.layoutManager = LinearLayoutManager(this)
        todoRV.adapter = todoadapter

        addButton.setOnClickListener {
            val todoText = todoET.text.toString()

            val addResult = mainviewmodel.addTodo(todoText)
            if(addResult)
            {
                //Toast.makeText(this, "Added to todo", Toast.LENGTH_LONG).show()
                (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            } else {
                //Toast.makeText(this, "Error! Empty text", Toast.LENGTH_LONG).show()
            }
        }

        clearButton.setOnClickListener {
            mainviewmodel.clearTodo()
        }

        mainviewmodel.getTodoList().observe(this, { thetodostrings ->

            todoadapter.updateTodo(thetodostrings)

            /*
            Log.d("pia9debug", "*** TODO ***")
            for(todo in thetodostrings)
            {
                Log.d("pia9debug", todo)
            }
             */
        })

        mainviewmodel.getErrormessage().observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

    }

}