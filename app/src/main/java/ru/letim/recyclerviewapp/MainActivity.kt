package ru.letim.recyclerviewapp

import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.letim.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.buttonAddTask.setOnClickListener {
            val editTextTask = EditText(this)
            val alertAddTask = AlertDialog.Builder(this).create()
            alertAddTask.setView(editTextTask)
            alertAddTask.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.add)) { _, _ ->
                val task = editTextTask.text.toString()
                if (task.isNotEmpty()) {
                    adapter.data += task
                    adapter.notifyItemInserted(adapter.data.size - 1)
                }
            }
            alertAddTask.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.cancel)) { _, _ -> }
            alertAddTask.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE) // чтобы автоматически появлялась клавиатура
            alertAddTask.show()
            editTextTask.requestFocus() // сделать фокус на тексте
        }
    }
}
