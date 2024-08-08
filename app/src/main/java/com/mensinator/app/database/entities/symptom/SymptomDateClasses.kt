package com.mensinator.app.database.entities.symptom

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SymptomWithDates(
    @Embedded val symptom: Symptom,
    @Relation(
        parentColumn = "id",
        entityColumn = "symptom_id",
        associateBy = Junction(SymptomDateCrossRef::class)
    )
    val symptomDates: List<SymptomDate>
)

data class DateWithSymptoms(
    @Embedded val symptomDate: SymptomDate,
    @Relation(
        parentColumn = "id",
        entityColumn = "symptom_date_id",
        associateBy = Junction(SymptomDateCrossRef::class)
    )
    val symptoms: List<Symptom>
)
