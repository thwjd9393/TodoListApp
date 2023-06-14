package com.jscompany.tp16todolistapp.model

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(
    context: Context,
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "TODO"

        // Table
        const val NO = "NO" //프라이머리키
        const val STATUS = "status"
        const val TITLE = "title"
        const val CONTENT = "content"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql : String = "CREATE TABLE IF NOT EXISTS TODO(" +
                "num INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "status INTEGER," +
                "title TEXT, " +
                "content TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val sql = "DROP TABLE IF EXISTS TODO"

        db?.execSQL(sql)
        onCreate(db)
    }

    // status 값에 따라 모든 todo값 불러오기
    @SuppressLint("Range")
    fun selectAll(status : Int) : List<TodoVO>{

        val todoList = ArrayList<TodoVO>()
        val selectQueryHandler = "SELECT * FROM TODO WHERE status = ?"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQueryHandler, arrayOf(arrayOf(status).toString()))
        if(cursor.moveToFirst()){
            do{
                val todo = TodoVO()
                todo.status = cursor.getInt(cursor.getColumnIndex(STATUS))
                todo.title = cursor.getString(cursor.getColumnIndex(TITLE))
                todo.Content = cursor.getString(cursor.getColumnIndex(CONTENT))

                todoList.add(todo)
            }while(cursor.moveToNext())
        }
        db.close()

        return todoList
    }

    // insert
    fun insertTodo(status: Int, title: String, content:String) {

        Log.d("TAG", "${status} , ${title}")
        val db = this.writableDatabase
        val query = "INSERT INTO TODO(status, title, content) " +
                "VALUES ('"+status+"', '"+title+"', '"+content+"')"

        db.execSQL(query)
        db.close()
    }

    // update
    fun updateTodo() {

    }

    // delete
    fun delTodo() {

    }

}
