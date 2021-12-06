package com.cellodove.recyclerview.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomDataEntity::class], version = 1)
abstract class RoomDataDatabase : RoomDatabase() {
    abstract fun gatewayDataDao() : RoomDataDao

    companion object {
        private var instance: RoomDataDatabase? = null

        @Synchronized
        fun getInstance(context: Context): RoomDataDatabase? {
            if (instance == null) {
                synchronized(RoomDataDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDataDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance
        }
    }
}
