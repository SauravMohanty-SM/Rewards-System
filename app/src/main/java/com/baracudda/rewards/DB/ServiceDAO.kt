package com.baracudda.rewards.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.baracudda.rewards.models.Services
import com.baracudda.rewards.models.UserDetails

@Dao
interface ServiceDAO {
    @Insert
    suspend fun insertService(serviceDetails: Services)

    @Update
    suspend fun updateService(serviceDetails: Services)

    @Delete
    suspend fun deleteService(serviceDetails: Services)

    @Query("SELECT * FROM Services")
    fun readService() : LiveData<List<Services>>
}