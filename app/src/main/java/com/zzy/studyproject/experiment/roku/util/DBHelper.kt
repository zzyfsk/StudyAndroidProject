package com.zzy.studyproject.experiment.roku.util

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE " +
                    "$TABLE_NAME " +
                    "($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COLUMN_USERNAME TEXT NOT NULL,$COLUMN_EMAIL TEXT UNIQUE)"

        db.execSQL(createTableQuery)
    }

    companion object {
        private const val DATABASE_NAME = "MyDatabase.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "User"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_EMAIL = "email"
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database upgrades if needed
    }
}