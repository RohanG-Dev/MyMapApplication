package com.example.mymapapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "property_table")
data class PropertyEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "property_name")
    var propertyName: String? = null,

    @ColumnInfo(name = "property_location")
    var propertyLocation: String? = null
)
