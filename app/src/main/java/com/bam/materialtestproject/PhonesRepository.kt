package com.bam.materialtestproject

import kotlin.random.Random

class PhonesRepository {
    companion object{
        var list = mutableListOf<Phone>()

        fun initList(){
            if (list.size == 0){
                for( i in 0..100){
                    list.add(Phone("name$i", "Country$i", Random(100).nextInt(), "color$i" ))
                }
            }
        }
    }





}