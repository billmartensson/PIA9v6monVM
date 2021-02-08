package se.magictechnology.pia9v6monvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewmodel : ViewModel() {

    private val todolist = MutableLiveData<List<String>>()

    private var todostrings = mutableListOf<String>()

    fun addTodo(todotext : String)
    {
        if(todotext != "")
        {
            todostrings.add(todotext)
        }

        todolist.value = todostrings
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