package com.bam.materialtestproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bam.materialtestproject.databinding.PhoneListItemBinding

class PhoneListAdapter(var phoneList: MutableList<Phone>): RecyclerView.Adapter<PhoneListAdapter.ViewHolder>() {


    private lateinit var listener: (Int) -> Unit

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = DataBindingUtil.findBinding<PhoneListItemBinding>(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val binding = PhoneListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder.binding != null){
            holder.binding.phone = phoneList[position]
            holder.binding.root.setOnClickListener {
                listener(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    fun listener(value: (Int) -> Unit) {
        listener = value
    }
}