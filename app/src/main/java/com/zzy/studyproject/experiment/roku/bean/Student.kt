package com.zzy.studyproject.experiment.roku.bean

data class Student(
    val name:String,
    val id:String,
    val age: String,
    val sex:String,
    val political:String,
    val address:String
){
    override fun toString(): String {
        return "$name $id $age $sex $political $address"
    }
}
