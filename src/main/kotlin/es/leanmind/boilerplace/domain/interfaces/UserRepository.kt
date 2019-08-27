package es.leanmind.boilerplace.domain.interfaces

import es.leanmind.boilerplace.domain.models.User

interface UserRepository {
    fun getUserById(userId: Int): User
}