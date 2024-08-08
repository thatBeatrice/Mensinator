package com.mensinator.app.database.entities.symptom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symptom_date")
data class SymptomDate(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "date")
    val date: String
)
