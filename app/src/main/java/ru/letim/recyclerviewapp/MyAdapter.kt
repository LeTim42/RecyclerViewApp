package ru.letim.recyclerviewapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.letim.recyclerviewapp.databinding.RecyclerViewItemBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var data = arrayOf<String>().toMutableList()

    class ViewHolder(val binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewTask.text = data[position]
        holder.binding.buttonTaskDone.setOnClickListener {
            val pos = holder.adapterPosition
            data.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

    override fun getItemCount() = data.size
}
