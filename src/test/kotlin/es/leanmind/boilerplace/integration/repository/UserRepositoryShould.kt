package es.leanmind.boilerplace.integration.repository

import es.leanmind.boilerplace.domain.interfaces.UserRepository
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class UserRepositoryShould {
    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun return_a_user() {
        val user = userRepository.getUserById(1)
        Assertions.assertThat(user.name).contains("Maik")
    }
}
