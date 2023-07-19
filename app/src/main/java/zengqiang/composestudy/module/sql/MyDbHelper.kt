package zengqiang.composestudy.module.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

const val TABLE_NAME = "test"

// 建表语句
private const val SQL_CREATE_ENTRIES =
    "CREATE TABLE $TABLE_NAME (${BaseColumns._ID} INTEGER  PRIMARY KEY AUTOINCREMENT,sortName TEXT)"

// 删表语句
private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"


class MyDbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // 数据库第一次初始化调用
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    // 数据库升级时调用，表结构发生变化
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        // 删除表
        db.execSQL(SQL_DELETE_ENTRIES)
        // 重新创建表
        onCreate(db)
        //也可在表中新增列元素， 使用 SQL的ALTER语句
//        String sql = "alter table "+TABLE_NAME+" add job varchar";
//        db.execSQL(sql);

    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"
    }
}