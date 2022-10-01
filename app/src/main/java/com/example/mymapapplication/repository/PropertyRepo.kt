package com.example.mymapapplication.repository

import android.app.Application
import android.content.Context
import com.example.mymapapplication.dao.PropertyDAO
import com.example.mymapapplication.database.PropertyDatabase
import com.example.mymapapplication.model.PropertyEntity

class PropertyRepo(private var dao: PropertyDAO) {


    fun insertPropertyInfo(propertyEntity: PropertyEntity) {
        dao?.insertPropertyInfo(propertyEntity)
    }
}