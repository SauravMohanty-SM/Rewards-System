package com.baracudda.rewards.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.baracudda.rewards.models.UserDetails

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(userDetails: UserDetails)

    @Update
    suspend fun updateUser(userDetails: UserDetails)

    @Delete
    suspend fun deleteUser(userDetails: UserDetails)

    @Query("SELECT * FROM User")
    fun readUser() : LiveData<List<UserDetails>>
}