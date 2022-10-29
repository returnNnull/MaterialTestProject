package com.bam.materialtestproject

import java.time.Year

class Phone(var name: String, var country: String, var createYear: Int, var color: String) {

    override fun toString(): String {
        return "Phone(name='$name', country='$country', createYear=$createYear, color='$color')"
    }
}