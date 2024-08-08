package com.mensinator.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.mensinator.app.database.entities.symptom.*

@Dao
interface SymptomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSymptom(symptom: Symptom)

    @Query("SELECT * FROM symptom")
    suspend fun getAllSymptoms(): List<Symptom>

    @Query("SELECT * FROM symptom WHERE is_active = :isActive")
    fun getActiveSymptoms(isActive: Boolean): List<Symptom>

    @Query("UPDATE symptom SET is_active = :isActive WHERE id = :id")
    suspend fun updateSymptomActiveById(id: Int, isActive: Boolean)

    @Query("DELETE FROM symptom WHERE id = :id")
    suspend fun deleteSymptomById(id: Int)

    @Transaction
    @Query("""
        SELECT symptom.*
        FROM symptom
        INNER JOIN symptom_date_cross_ref ON symptom.id = symptom_date_cross_ref.symptom_id
        INNER JOIN symptom_date ON symptom_date_cross_ref.symptom_date_id = symptom_date.id
        WHERE symptom_date.date = :date
    """)
    suspend fun getSymptomsByDate(date: String): List<Symptom>
}