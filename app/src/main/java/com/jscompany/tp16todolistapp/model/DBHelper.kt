package com.jscompany.tp16todolistapp.model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(
    context: Context,
) : SQLiteOpenHelper(context, TABLE_NAME, null, DATABASE_VERSION) {
    companion object{
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "TODO"

        // Table
        const val NUM = "num" //프라이머리키
        const val STATUS = "status"
        const val TITLE = "title"
        const val CONTENT = "content"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql : String = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "$NUM INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$STATUS TEXT, " +
                "$TITLE TEXT, " +
                "$CONTENT TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val sql = "DROP TABLE IF EXISTS $TABLE_NAME"

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
        val db = this.writableDatabase //데이터베이스를 오픈 외부에서 받아온 데이터를 contentValues로 묶음
//        val query = "INSERT INTO $TABLE_NAME ($STATUS, $TITLE, $CONTENT) " +
//                "VALUES ('"+status+"', '"+title+"', '"+content+"')"
//        db.execSQL(query)

        val contentValues = ContentValues().apply {
            put(STATUS, status.toString())
            put(TITLE, title)
            put(CONTENT, content)
        }
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    // update
    fun updateTodo() {

    }

    // delete
    fun delTodo() {

    }

}
