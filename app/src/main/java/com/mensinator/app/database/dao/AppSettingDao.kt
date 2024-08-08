package com.mensinator.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mensinator.app.database.entities.AppSetting

@Dao
interface AppSettingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppSetting(appSetting: AppSetting)

    @Query("SELECT * FROM app_setting")
    suspend fun getAllSettings(): List<AppSetting>

    @Query("SELECT * FROM app_setting WHERE category = :category")
    suspend fun getSettingsByCategory(category: String): List<AppSetting>?
}