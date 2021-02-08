package se.magictechnology.pia9v6monvm

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewmodel : ViewModel() {

    private val errorMessage = MutableLiveData<String>()

    private val todolist = MutableLiveData<List<String>>()

    private var todostrings = mutableListOf<String>()

    fun getErrormessage() : LiveData<String>
    {
        return errorMessage
    }

    fun addTodo(todotext : String) : Boolean
    {
        if(todotext != "")
        {
            todostrings.add(todotext)
        } else {
            // FEL! Tom text
            errorMessage.value = "No todo text!!!"
            return false
        }

        todolist.value = todostrings

        return true
    }

    fun getTodoList() : LiveData<List<String>>
    {
        return todolist
    }

    fun clearTodo()
    {
        todostrings.clear()

        todolist.value = todostrings
    }

}