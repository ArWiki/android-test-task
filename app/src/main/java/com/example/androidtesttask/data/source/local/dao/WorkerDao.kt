package com.example.androidtesttask.data.source.local.dao

import androidx.room.*
import com.example.androidtesttask.domain.model.WorkerDB
import com.example.androidtesttask.domain.model.WorkerFavorite

@Dao
interface WorkerDao {

    // Table Worker
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(worker: WorkerDB): Long

    @Query("SELECT * FROM Worker")
    fun loadAll(): MutableList<WorkerDB>

    @Delete
    fun delete(worker: WorkerDB)

    @Query("DELETE FROM Worker")
    fun deleteAll()

    @Update
    fun update(worker: WorkerDB)

    // Table WorkerFavorite
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWorkerFavorite(worker: WorkerFavorite): Long

    @Delete
    fun deleteWorkerFavorite(worker: WorkerFavorite)

    @Query("SELECT * FROM WorkerFavorite where lastName = :lastName AND firstName =:firstName AND birthday =:birthday")
    fun getFavorite(lastName: String?, firstName: String?, birthday: String?): WorkerFavorite?

    @Query("SELECT * FROM WorkerFavorite where lastName = :lastName AND firstName =:firstName")
    fun isFavorite(lastName: String?, firstName: String?): WorkerFavorite?
}