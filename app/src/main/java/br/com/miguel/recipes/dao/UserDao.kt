package br.com.miguel.recipes.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.miguel.recipes.model.User


@Dao
interface UserDao {

    @Insert
    fun save(user: User): Int

    @Delete
    fun delete(user: User): Int

    @Update
    fun update(user: User): Int

    @Query("SELECT * FROM USERS WHERE id = :id")
    fun getUserById(id: Int): User?

    @Query("SELECT * FROM USERS WHERE email = :email")
    fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM USERS WHERE email = :email AND password = :password")
    fun login(email: String, password: String): User?




}