package com.cellodove.recyclerview.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomDataDao {
    @Query("SELECT * FROM userInfo")
    fun getGatewayData() : List<RoomDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomData : RoomDataEntity) :Long

    @Query("delete from userInfo")
    fun delete()

}
