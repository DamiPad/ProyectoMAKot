package com.example.finalproject.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = User.TABLE_NAME)
data class User (
    @ColumnInfo(name = "user_name")@NotNull var userName:String,
    @ColumnInfo(name = "phone_user") var phoneUser:String,
    @ColumnInfo(name = "email_user")@NotNull var userEmail: String,
    @ColumnInfo(name = "pass_user")@NotNull var userPass:String,
    @ColumnInfo(name = "update_at")@NotNull var userUpdateAt: Date



){
    companion object{
        const val TABLE_NAME = "tblUser"
    }
    //se coloco fuera porque no es un parametro
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")@NotNull var userId:Int=0


}