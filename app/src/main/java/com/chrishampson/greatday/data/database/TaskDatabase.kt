package com.chrishampson.greatday.data.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.chrishampson.greatday.data.Task
import java.util.*
import java.util.concurrent.Executors


/**
 * Created by chris on 16/05/18.
 */
@Database(entities =  [Task::class], version = 1)
@TypeConverters(Converters::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase? {
            if (INSTANCE == null) {
                synchronized(TaskDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            TaskDatabase::class.java, "task.db")
                            .addCallback(object : Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    Executors.newSingleThreadScheduledExecutor().execute({
                                        getInstance(context)!!.taskDao().insertTask(Task(1, "Hello", false, Date()))
                                    })
                                }
                            })
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }

//        private fun buildDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(context,
//                    AppDatabase::class.java!!,
//                    "my-database")
//                    .addCallback(object : RoomDatabase.Callback() {
//                        override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
//                            super.onCreate(db)
//                            Executors.newSingleThreadScheduledExecutor().execute(Runnable { getInstance(context).dataDao().insertAll(DataEntity.populateData()) })
//                        }
//                    })
//                    .build()
//        }
    }
}