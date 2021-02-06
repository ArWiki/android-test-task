package com.example.androidtesttask.data.source.local.dao

import androidx.room.*
import com.example.androidtesttask.domain.model.WorkerDatabase
import com.example.androidtesttask.domain.model.WorkerFavorite
import io.reactivex.Single

@Dao
interface WorkerDao {

    // Table Worker
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(worker: WorkerDatabase): Long

    @Query("SELECT * FROM Worker")
    fun loadAll(): MutableList<WorkerDatabase>

    @Query("SELECT * FROM Worker where specialityId = :specialtyId")
    fun loadWorkerBySpecialtyId(specialtyId: Int?): Single<MutableList<WorkerDatabase>>

    @Delete
    fun delete(worker: WorkerDatabase)

    @Query("DELETE FROM Worker")
    fun deleteAll()

    @Update
    fun update(worker: WorkerDatabase)

    // Table WorkerFavorite
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWorkerFavorite(worker: WorkerFavorite): Long

    @Query("DELETE FROM WorkerFavorite where lastName = :lastName AND firstName =:firstName AND birthday =:birthday")
    fun deleteWorkerFavorite(lastName: String?, firstName: String?, birthday: String?)

    @Query("SELECT * FROM WorkerFavorite where lastName = :lastName AND firstName =:firstName AND birthday =:birthday")
    fun getFavorite(lastName: String?, firstName: String?, birthday: String?): WorkerFavorite?

    @Query("SELECT * FROM WorkerFavorite where lastName = :lastName AND firstName =:firstName AND birthday =:birthday")
    fun isFavorite(lastName: String?, firstName: String?, birthday: String?): WorkerFavorite?
}