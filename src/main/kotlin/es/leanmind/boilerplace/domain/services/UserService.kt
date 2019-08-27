package es.leanmind.boilerplace.domain.services

import es.leanmind.boilerplace.domain.interfaces.UserRepository
import es.leanmind.boilerplace.domain.models.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired private val userRepository: UserRepository) {

    fun getUserById(userId: Int): User {
        return userRepository.getUserById(userId)
    }

}