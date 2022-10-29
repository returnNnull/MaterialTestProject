package com.bam.materialtestproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PhoneListAdapter(context: Context, resId: Int, var inflater: LayoutInflater) :
    ArrayAdapter<Phone>(context, resId) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        if (convertView == null) {
            val v: View = inflater.inflate(R.layout.phone_list_item, parent, false)
            val name: TextView = v.findViewById(R.id.nameTextView)
            val country: TextView = v.findViewById(R.id.countryTextView)
            val color: TextView = v.findViewById(R.id.colorTextView)
            val year: TextView = v.findViewById(R.id.yearTextView)

            val phone = getItem(position)

            if (phone != null) {
                name.text = phone.name
                country.text = phone.country
                color.text = phone.color
                year.text = phone.createYear.toString()
            }
            return v
        } else return convertView

    }
}