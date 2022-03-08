package com.baracudda.rewards.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserDetails(
    @PrimaryKey(autoGenerate = true)
    val userID: Long,
    val userName: String,
    val MemberSince: String,
    val UserCreatedAt: String,
    val UserHobbies: String,
    val sessionToken: Long
)
