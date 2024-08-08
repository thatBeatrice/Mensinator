package com.mensinator.app.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "app_setting", indices = [Index(value = ["label"], unique = true)])
data class AppSetting(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "label")
    val label: String,

    @ColumnInfo(name = "value")
    val value: String,

    @ColumnInfo(name = "category")
    val category: String
)
