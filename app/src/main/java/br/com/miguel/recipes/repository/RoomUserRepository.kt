package br.com.miguel.recipes.repository

import android.content.Context
import br.com.miguel.recipes.dao.RecipeDatabase
import br.com.miguel.recipes.model.User

class RoomUserRepository(context: Context) : UserRepository {

    private val userDao = RecipeDatabase.getDatabase(context).userDao()

    override fun saveUser(user: User) {
        userDao.save(user)
    }

    override fun getUser(): User {
        TODO("Not yet implemented")
    }

    override fun getUser(id: Int): User {
        return userDao.getUserById(1) ?: User()
    }

    override fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }

    override fun login(email: String, password: String): Boolean {
        val user = userDao.login(email, password)
        return user != null

    }

}