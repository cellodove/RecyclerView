package com.cellodove.recyclerview.repository.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userInfo")
data class RoomDataEntity (
    @PrimaryKey
    var id: Int,
    val userNo : Long?,
    val userId : String?,
    val givenName : String?,

)