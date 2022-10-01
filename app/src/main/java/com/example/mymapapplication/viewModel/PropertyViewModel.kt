package com.example.mymapapplication.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.mymapapplication.database.PropertyDatabase
import com.example.mymapapplication.model.PropertyEntity
import com.example.mymapapplication.repository.PropertyRepo

class PropertyViewModel(application: Application) : AndroidViewModel(application) {

    var repo: PropertyRepo? = null

    init {
        val dao = PropertyDatabase.getDbInstance(application)?.propertyDAO
        repo = dao?.let { PropertyRepo(it) }
    }

    fun insertPropertyInfoVM(propertyEntity: PropertyEntity) {
        repo?.insertPropertyInfo(propertyEntity)
    }
}