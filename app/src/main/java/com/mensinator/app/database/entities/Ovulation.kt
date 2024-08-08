package com.mensinator.app.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "ovulation", indices = [Index(value = ["date"], unique = true)])
data class Ovulation(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "date")
    val date: String
)
