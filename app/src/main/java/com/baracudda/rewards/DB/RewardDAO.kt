package com.baracudda.rewards.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.baracudda.rewards.models.Rewards

@Dao
interface RewardDAO {
    @Insert
    suspend fun insertReward(rewardDetails: Rewards)

    @Update
    suspend fun updateReward(rewardDetails: Rewards)

    @Delete
    suspend fun deleteReward(rewardDetails: Rewards)

    @Query("SELECT * FROM Rewards")
    fun readReward() : LiveData<List<Rewards>>
}