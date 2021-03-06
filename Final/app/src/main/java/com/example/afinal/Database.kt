package com.example.afinal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.afinal.dao.CategoryDao
import com.example.afinal.dao.CountryDao

@Database(entities = [Country::class, Category::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun countryDao(): CountryDao
    abstract fun categoryDao(): CategoryDao
}