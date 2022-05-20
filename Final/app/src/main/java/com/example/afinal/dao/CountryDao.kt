package com.example.afinal.dao

import androidx.room.*

@Dao
interface CountryDao {
    @Query("SELECT * FROM country")
    fun getAll(): List<Country>

    @Insert
    fun insert(vararg items: Country)
}