package se.magictechnology.pia9v6monvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter() : RecyclerView.Adapter<TodoViewHolder>() {

    var todolist : List<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val vh = TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false))
        return vh
    }

    fun updateTodo(todostrings : List<String>)
    {
        todolist = todostrings
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        todolist?.let {
            return it.size
        }
        return  0
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentString = todolist!![position]

        holder.todotextview.text = currentString
    }

}

class TodoViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val todotextview = view.findViewById<TextView>(R.id.todoTextview)

}