package com.example.minhascores

import android.content.ContentValues
import android.content.Context

class ColorDAO {
    var database: BDHelper

    constructor(context: Context){
        this.database = BDHelper(context)
    }

    fun get (): ArrayList<Collor> {
        val colors = ArrayList<Collor>()
        val columns = arrayOf("id", "name", "code")
        val cursor = this.database.readableDatabase.query("colors", columns, null, null, null, null, "name")

        cursor.moveToFirst()

        for (i in 1..cursor.count){
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val code = cursor.getInt(cursor.getColumnIndex("code"))
            colors.add(Collor(id, name, code))
            cursor.moveToNext()
        }
        return colors
    }

    fun find (id: Int): Collor? {
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val columns = arrayOf("id", "name", "code")
        val cursor = this.database.readableDatabase.query("colors", columns, where, pWhere, null, null, null)

        cursor.moveToFirst()

        if (cursor.count == 1){
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val code = cursor.getInt(cursor.getColumnIndex("code"))
            return Collor(id, name, code)
        }
        return null
    }

    fun insert (collor: Collor){
        val cv = ContentValues()
        cv.put("name", collor.name)
        cv.put("code", collor.code)
        this.database.writableDatabase.insert("colors", null, cv)
    }

    fun update (collor: Collor) {
        val where = "id = ?"
        val pWhere = arrayOf(collor.id.toString())
        val cv = ContentValues()
        cv.put("name", collor.name)
        cv.put("code", collor.code)
        this.database.writableDatabase.update("colors", cv, where, pWhere)
    }

    fun delete (id: Int) {
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.database.writableDatabase.delete("colors", where, pWhere)
    }

    fun count (): Int {
        val cursor = this.database.readableDatabase.rawQuery("select count(id) from colors", null)
        cursor.moveToNext()
        return cursor.getInt(0)
    }
}