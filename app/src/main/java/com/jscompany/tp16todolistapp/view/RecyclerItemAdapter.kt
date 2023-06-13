package com.jscompany.tp16todolistapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jscompany.tp16todolistapp.R
import com.jscompany.tp16todolistapp.databinding.RecyclerItemBinding
import com.jscompany.tp16todolistapp.model.TodoVO

class RecyclerItemAdapter(val items : List<TodoVO>) : Adapter<RecyclerItemAdapter.VH>() {

    inner class VH(val binding : RecyclerItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
        = VH(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_item, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.item = items[position]
    }

}