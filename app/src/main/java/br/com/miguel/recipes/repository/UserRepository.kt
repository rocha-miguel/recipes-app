package br.com.miguel.recipes.repository

import br.com.miguel.recipes.model.User

interface UserRepository {

    fun saveUser(user: User)
    fun getUser(): User
    fun getUserByEmail(email: String): User?
    fun login(email: String, password: String): Boolean


}