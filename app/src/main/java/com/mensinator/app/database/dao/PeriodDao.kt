package com.mensinator.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mensinator.app.database.entities.Period

@Dao
interface PeriodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPeriod(period: Period)

    @Query("SELECT * FROM period")
    suspend fun getAllPeriods(): List<Period>

    @Query("DELETE FROM period WHERE id = :id")
    suspend fun deletePeriodById(id: Long)
}