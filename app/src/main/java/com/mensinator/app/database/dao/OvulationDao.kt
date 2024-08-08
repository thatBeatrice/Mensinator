package com.mensinator.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mensinator.app.database.entities.Ovulation

@Dao
interface OvulationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOvulation(ovulation: Ovulation)

    @Query("SELECT * FROM ovulation")
    suspend fun getAllOvulations(): List<Ovulation>

    @Query("SELECT * FROM ovulation WHERE date = :date")
    suspend fun getOvulationByDate(date: String): Ovulation

    @Query("DELETE FROM ovulation WHERE id = :id")
    suspend fun deleteOvulationById(id: Long)
}