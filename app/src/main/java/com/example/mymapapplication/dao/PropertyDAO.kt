package com.example.mymapapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.mymapapplication.model.PropertyEntity


@Dao
interface PropertyDAO {

    @Insert
    fun insertPropertyInfo(propertyInfo: PropertyEntity)
}