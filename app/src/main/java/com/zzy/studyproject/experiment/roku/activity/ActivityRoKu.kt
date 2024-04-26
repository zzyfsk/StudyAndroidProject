package com.zzy.studyproject.experiment.roku.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zzy.studyproject.R
import java.io.BufferedReader
import java.io.InputStreamReader

class ActivityRoKu:AppCompatActivity() {

    private lateinit var editTextName:EditText
    private lateinit var editTextId:EditText
    private lateinit var editTextAge:EditText
    private lateinit var editTextSex:EditText
    private lateinit var editTextPolitical:EditText
    private lateinit var editTextAddress:EditText

    private lateinit var buttonXMLRead:Button
    private lateinit var buttonXMLWrite:Button
    private lateinit var buttonRead:Button
    private lateinit var buttonWrite:Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity6)
        init()

        sharedPreferences = getSharedPreferences("student_info", Context.MODE_PRIVATE)

    }

    private fun init(){
        editTextName = findViewById(R.id.activity6_1)
        editTextId = findViewById(R.id.activity6_2)
        editTextAge  = findViewById(R.id.activity6_3)
        editTextSex = findViewById(R.id.activity6_4)
        editTextPolitical = findViewById(R.id.activity6_5)
        editTextAddress = findViewById(R.id.activity6_6)

        buttonXMLRead = findViewById(R.id.activity6_button_1)
        buttonXMLWrite = findViewById(R.id.activity6_button_2)
        buttonRead = findViewById(R.id.activity6_button_3)
        buttonWrite = findViewById(R.id.activity6_button_4)

        buttonXMLWrite.setOnClickListener{
            readXML()
        }

        buttonXMLWrite.setOnClickListener{
            writeXML()
        }

        buttonRead.setOnClickListener{
            read()
        }

        buttonWrite.setOnClickListener{
            write()
        }
    }

    fun readXML(){
        try {
            val fileInputStream = openFileInput("student_info.xml")
            val bufferedReader = BufferedReader(InputStreamReader(fileInputStream))
            val xmlData = bufferedReader.use(BufferedReader::readText)
            bufferedReader.close()
            fileInputStream.close()

            val startIndex = xmlData.indexOf("<name>") + "<name>".length
            val endIndex = xmlData.indexOf("</name>")
            val name = xmlData.substring(startIndex, endIndex)
            editTextName.setText(name)

            // 同样的方式解析其他属性并填充回输入框
            toast("读取xml成功")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun writeXML(){
        val xmlData = "<student>" +
                "<name>${editTextName.text}</name>" +
                "<id>${editTextId.text}</id>" +
                "<age>${editTextAge.text}</age>" +
                "<sex>${editTextSex.text}</sex>" +
                "<political>${editTextPolitical.text}</political>" +
                "<address>${editTextAddress.text}</address>" +
                "</student>"

        try {
            val fileOutputStream = openFileOutput("student_info.xml", Context.MODE_PRIVATE)
            val printWriter = fileOutputStream.bufferedWriter()
            printWriter.write(xmlData)
            printWriter.close()
            fileOutputStream.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
        toast("写入xml成功")
    }

    fun read(){
        val name = sharedPreferences.getString("name", "")
        val id = sharedPreferences.getString("id", "")
        val age = sharedPreferences.getString("age", "")
        val sex = sharedPreferences.getString("sex", "")
        val political = sharedPreferences.getString("political", "")
        val address = sharedPreferences.getString("address", "")

        editTextName.setText(name)
        editTextId.setText(id)
        editTextAge.setText(age)
        editTextSex.setText(sex)
        editTextPolitical.setText(political)
        editTextAddress.setText(address)
        toast("读取sharedPreference成功")
    }

    fun write(){
        val editor = sharedPreferences.edit()
        editor.putString("name", editTextName.text.toString())
        editor.putString("id", editTextId.text.toString())
        editor.putString("age", editTextAge.text.toString())
        editor.putString("sex", editTextSex.text.toString())
        editor.putString("political", editTextPolitical.text.toString())
        editor.putString("address", editTextAddress.text.toString())
        editor.apply()
        toast("写入sharedPreference成功")
    }

    fun toast(str:String){
        val toast = Toast.makeText(this,str,Toast.LENGTH_LONG)
        toast.show()
    }
}