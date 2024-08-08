package com.mensinator.app.database.entities.symptom

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "symptom_date_cross_ref", primaryKeys = ["symptom_id", "symptom_date_id"])
data class SymptomDateCrossRef(
    @ColumnInfo(name = "symptom_id")
        val symptomId: Int,

    @ColumnInfo(name = "symptom_date_id")
    val symptomDateId: Long
)
