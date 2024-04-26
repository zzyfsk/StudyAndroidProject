package com.zzy.studyproject.experiment.nana

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R
import com.zzy.studyproject.experiment.roku.bean.Student
import com.zzy.studyproject.experiment.san.adapter.PersonAdapter

class ActivityNaNa :AppCompatActivity(){
    private lateinit var editTextName: EditText
    private lateinit var editTextId: EditText
    private lateinit var editTextAge: EditText
    private lateinit var editTextSex: EditText
    private lateinit var editTextPolitical: EditText
    private lateinit var editTextAddress: EditText

    private lateinit var buttonXMLRead: Button
    private lateinit var buttonXMLWrite: Button
    private lateinit var buttonRead: Button
    private lateinit var buttonWrite: Button
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var listView:ListView
    private lateinit var list:List<Student>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity7)
        init()
        viewStudents()
        val adapter = EditAdapter(this, list, {

        }) {

        }
        listView.adapter = adapter
    }

    private fun init(){
        databaseHelper = DatabaseHelper(this)
        editTextName = findViewById(R.id.activity7_1)
        editTextId = findViewById(R.id.activity7_2)
        editTextAge  = findViewById(R.id.activity7_3)
        editTextSex = findViewById(R.id.activity7_4)
        editTextPolitical = findViewById(R.id.activity7_5)
        editTextAddress = findViewById(R.id.activity7_6)

        buttonXMLRead = findViewById(R.id.activity7_button_1)
        buttonXMLWrite = findViewById(R.id.activity7_button_2)
        buttonRead = findViewById(R.id.activity7_button_3)
        buttonWrite = findViewById(R.id.activity7_button_4)
        listView = findViewById(R.id.activity7_list)

        buttonXMLRead.setOnClickListener{
            deleteStudent()
        }

        buttonXMLWrite.setOnClickListener{
            saveStudent()
        }

        buttonRead.setOnClickListener{
            updateStudent()
        }

        buttonWrite.setOnClickListener{

        }
    }

    private fun saveStudent() {
        // 获取输入的学生信息
        val name = editTextName.text.toString()
        val id = editTextId.text.toString()
        val age = editTextAge.text.toString()
        val sex = editTextSex.text.toString()
        val political = editTextPolitical.text.toString()
        val address = editTextAddress.text.toString()

        val student = Student(name,id,age,sex,political, address)

        databaseHelper.insertStudent(student)

        Toast.makeText(this, "学生信息已保存", Toast.LENGTH_SHORT).show()
        viewStudents()
    }

    private fun viewStudents() {
        println("here")
        list = databaseHelper.getAllStudents()
        val adapter = EditAdapter(this, list, {

        }) {

        }
        listView.adapter = adapter
    }

    private fun updateStudent() {
        val name = editTextName.text.toString()
        val id = editTextId.text.toString()
        val age = editTextAge.text.toString()
        val sex = editTextSex.text.toString()
        val political = editTextPolitical.text.toString()
        val address = editTextAddress.text.toString()

        val student = Student(name,id,age,sex,political, address)

        databaseHelper.updateStudent(student)

        Toast.makeText(this, "学生信息已更新", Toast.LENGTH_SHORT).show()
        viewStudents()
    }

    private fun deleteStudent() {
        databaseHelper.deleteStudent(editTextId.text.toString())
        Toast.makeText(this, "学生信息已删除", Toast.LENGTH_SHORT).show()
        viewStudents()
    }


}