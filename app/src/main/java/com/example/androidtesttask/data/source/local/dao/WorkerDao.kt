package com.example.androidtesttask.data.source.local.dao

import androidx.room.*
import com.example.androidtesttask.domain.model.WorkerDB

@Dao
interface WorkerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(worker: WorkerDB): Long

    @Query("SELECT * FROM Worker")
    fun loadAll(): MutableList<WorkerDB>

    @Delete
    fun delete(worker: WorkerDB)

    @Query("DELETE FROM Worker")
    fun deleteAll()

    /*@Query("SELECT * FROM Worker where id = :photoId")
    fun loadOneByWorkerId(photoId: Long): WorkerDB?

    @Query("SELECT * FROM Worker where lastName = :lastName")
    fun loadOneByWorkerLastName(lastName: String): WorkerDB?*/

    @Update
    fun update(worker: WorkerDB)
}