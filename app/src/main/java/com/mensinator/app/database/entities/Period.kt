package com.mensinator.app.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "period", indices = [Index(value = ["date"], unique = true)])
data class Period (
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "cycle_id")
    val cycle: Int
)