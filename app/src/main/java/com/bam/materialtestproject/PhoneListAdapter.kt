package com.bam.materialtestproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhoneListAdapter(var phoneList: MutableList<Phone>): RecyclerView.Adapter<PhoneListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var country: TextView
        var year: TextView
        var color: TextView

        init {
            name = itemView.findViewById(R.id.nameTextView)
            country = itemView.findViewById(R.id.countryTextView)
            year = itemView.findViewById(R.id.yearTextView)
            color = itemView.findViewById(R.id.colorTextView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.phone_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = phoneList[position].name
        holder.color.text = phoneList[position].color
        holder.country.text = phoneList[position].country
        holder.year.text = phoneList[position].createYear.toString()
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }
}