package com.bam.materialtestproject

import kotlin.random.Random

class PhonesRepository {
    companion object{
        private var list = mutableListOf<Phone>()


        fun getPhoneById(id: Int) = list[id]

        fun insertPhone(phone: Phone){
            list.add(0, phone)
        }

        fun deletePhone(id: Int) = list.removeAt(id)


        fun updatePhone(id: Int, phone: Phone) {
            val item = list[id]
            item.name = phone.name
            item.country = phone.country
            item.color = phone.color
            item.createYear = phone.createYear
        }

        fun getAllPhones() = list

        fun initList(){
            if (list.size == 0){
                for( i in 0..100){
                    list.add(Phone("name$i", "Country$i", Random(100).nextInt(), "color$i" ))
                }
            }
        }
    }





}