package com.mensinator.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.mensinator.app.database.entities.symptom.*

@Dao
interface SymptomDateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSymptomDate(symptomDate: SymptomDate)

    @Query("SELECT * FROM symptom_date")
    suspend fun getAllSymptomDates(): List<SymptomDate>

    @Query("DELETE FROM symptom_date WHERE id = :id")
    suspend fun deleteSymptomDateById(id: Long)

    @Query("DELETE FROM symptom_date WHERE date = :date")
    suspend fun deleteSymptomDateByDate(date: String)

    @Transaction
    @Query("""
        SELECT symptom_date.*
        FROM symptom
        INNER JOIN symptom_date_cross_ref ON symptom.id = symptom_date_cross_ref.symptom_id
        INNER JOIN symptom_date ON symptom_date_cross_ref.symptom_date_id = symptom_date.id
        WHERE symptom.name = :name
    """)
    suspend fun getSymptomDatesByName(name: String): List<SymptomDate>
}