package com.example.androidtesttask.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtesttask.data.source.local.dao.WorkerDao
import com.example.androidtesttask.domain.model.WorkerDB

@Database(entities = [WorkerDB::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val workerDao: WorkerDao

    companion object {
        const val DB_NAME = "WorkersDatabase.db"
    }
}