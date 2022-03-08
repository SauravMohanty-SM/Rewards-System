package com.baracudda.rewards.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Services")
data class Services(
    @PrimaryKey(autoGenerate = true)
    val ServiceId: Long,
    val ServiceName: String,
    val ServiceDesc: String,
    val ServiceReward: Long,
    val ServiceFormula: String
    )
