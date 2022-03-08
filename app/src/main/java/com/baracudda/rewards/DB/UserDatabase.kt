package com.baracudda.rewards.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.baracudda.rewards.models.Rewards
import com.baracudda.rewards.models.Services
import com.baracudda.rewards.models.UserDetails


@Database(entities = [UserDetails::class, Services::class, Rewards::class], version = 4, exportSchema = true)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO
    abstract fun serviceDao(): ServiceDAO
    abstract fun rewardDao(): RewardDAO

    companion object {
        @Volatile
        private var INSTAVCE: UserDatabase? = null

        val MIGRATION_2_3: Migration = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `Rewards` (`UserID` INTEGER NOT NULL, " +
                            "`Service1` INTEGER NOT NULL, " +
                            "`Service2` INTEGER NOT NULL, " +
                            "`Service3` INTEGER NOT NULL, " +
                            "PRIMARY KEY(`UserID`))"
                )
            }
        }

        fun getDatabase(context: Context): UserDatabase {
            if (INSTAVCE == null) {
                synchronized(this) {
                    INSTAVCE = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "UserDB"
                    ).addMigrations(MIGRATION_2_3)
                        .build()
                }
            }
            return INSTAVCE!!
        }
    }
}