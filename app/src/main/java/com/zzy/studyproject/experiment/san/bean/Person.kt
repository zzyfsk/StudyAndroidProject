package com.zzy.studyproject.experiment.san.bean

data class Person(val name:String,var times:Int = 0){
    override fun toString(): String {
        return "$name click times:$times"
    }
}
