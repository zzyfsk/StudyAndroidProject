package com.zzy.studyproject.experiment.nana

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.zzy.studyproject.experiment.roku.bean.Student

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "students.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "students"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_AGE = "age"
        private const val COLUMN_SEX = "sex"
        private const val COLUMN_POLITICAL = "political"
        private const val COLUMN_ADDRESS = "address"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME ($COLUMN_ID TEXT PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_AGE TEXT, $COLUMN_SEX TEXT ,$COLUMN_POLITICAL TEXT ,$COLUMN_ADDRESS TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 如果需要升级数据库结构，可以在这里处理
        // 例如，可以使用 ALTER TABLE 语句添加新列或删除旧列
    }

    fun insertStudent(student: Student) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ID, student.id)
        values.put(COLUMN_NAME, student.name)
        values.put(COLUMN_AGE, student.age)
        values.put(COLUMN_SEX, student.sex)
        values.put(COLUMN_POLITICAL, student.political)
        values.put(COLUMN_ADDRESS, student.address)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllStudents(): List<Student> {
        val students = mutableListOf<Student>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val age = cursor.getString(cursor.getColumnIndex(COLUMN_AGE))
                val sex = cursor.getString(cursor.getColumnIndex(COLUMN_SEX))
                val political = cursor.getString(cursor.getColumnIndex(COLUMN_POLITICAL))
                val address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS))
                students.add(
                    Student(
                        name,
                        id ?: "1",
                        age ?: "null",
                        sex ?: "null",
                        political ?: "null",
                        address ?: "null"
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        println(students.size)
        return students
    }

    fun updateStudent(student: Student) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ID, student.id)
        values.put(COLUMN_NAME, student.name)
        values.put(COLUMN_AGE, student.age)
        values.put(COLUMN_SEX, student.sex)
        values.put(COLUMN_POLITICAL, student.political)
        values.put(COLUMN_ADDRESS, student.address)
        db.update(TABLE_NAME, values, "$COLUMN_ID=?", arrayOf(student.id))
        db.close()
    }

    fun deleteStudent(id: String) {
        val db = writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(id))
        db.close()
    }
}