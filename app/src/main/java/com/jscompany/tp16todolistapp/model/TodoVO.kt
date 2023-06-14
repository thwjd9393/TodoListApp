package com.jscompany.tp16todolistapp.model

import java.io.Serializable

data class TodoVO(
    var status : Int,
    var title:String,
    var Content :String,
): Serializable {
    constructor(): this(0,"","")

}
