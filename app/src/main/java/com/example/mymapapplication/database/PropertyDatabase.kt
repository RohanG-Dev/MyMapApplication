package com.example.mymapapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mymapapplication.dao.PropertyDAO
import com.example.mymapapplication.model.PropertyEntity


@Database(entities = [PropertyEntity::class], exportSchema = false, version = 1)
abstract class PropertyDatabase : RoomDatabase() {


    abstract val propertyDAO: PropertyDAO?

    companion object {
        var dbinstance: PropertyDatabase? = null
        fun getDbInstance(context: Context): PropertyDatabase? {
            if (dbinstance == null) {
                dbinstance = Room.databaseBuilder(
                    context.applicationContext,
                    PropertyDatabase::class.java,
                    "property_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dbinstance
        }
    }


}