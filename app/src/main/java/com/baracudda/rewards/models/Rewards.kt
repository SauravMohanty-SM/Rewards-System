package com.baracudda.rewards.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Rewards")
data class Rewards(
    @PrimaryKey(autoGenerate = true)
    val UserID: Long,
    val Service1: Long,
    val Service2: Long,
    val Service3: Long
)
