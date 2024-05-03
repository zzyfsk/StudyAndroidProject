package com.zzy.studyproject.experiment.hachi

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.zzy.studyproject.R

class ActivityHaChi : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var list: MutableList<Contacts>
    private lateinit var listView: ListView
    private lateinit var adapter: ActivityHaChiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activyty8)
        init()
        listView.adapter = adapter

    }

    private fun init() {
        button1 = findViewById(R.id.activity8_button_1)
        button2 = findViewById(R.id.activity8_button_2)
        button3 = findViewById(R.id.activity8_button_3)
        button4 = findViewById(R.id.activity8_button_4)
        listView = findViewById(R.id.activity8_list)

        list = mutableListOf()

        adapter = ActivityHaChiAdapter(this,list)

        button1.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.READ_CONTACTS), 1
                )
            } else {
                readContacts()
            }
        }
    }

    @SuppressLint("Range")
    fun readContacts() {
        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        try {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    list.add(
                        Contacts(
                            cursor.getString(
                                cursor.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                                )
                            ),
                            cursor.getString(
                                cursor.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER
                                )
                            )
                        )
                    )
                }
            }
            list.forEach {
                println(it.toString())
            }
            adapter.notifyDataSetChanged()
        } catch (e:Exception){
            println(e.localizedMessage)
        }finally {
            cursor?.close()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts()
                } else {
                    Toast.makeText(this, "获取联系人权限失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}