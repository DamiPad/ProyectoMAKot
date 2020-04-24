package com.example.finalproject.database

import androidx.room.*

@Dao
interface UserDAO {
    @Insert
    fun insertUser(user: User)//clae user representacion de la tabla a la base de datos (nombre del parametro que recibe: Clase user)

    @Update
    fun updateUser(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM tblUser WHERE user_id = :id ")
    fun getUserById(id:Long): User

    @Query("SELECT * FROM tblUser ORDER BY user_name ")
    fun getAllUser():List<User>//lo regresamos en forma de lista

    @Query("SELECT * FROM tblUser WHERE user_name = :user AND pass_user=:pwd")
    fun validateuser(user:String, pwd:String): User?


    @Query("select * from tblUser order by user_name")
    fun loadAllUser() : List<User>

    

}