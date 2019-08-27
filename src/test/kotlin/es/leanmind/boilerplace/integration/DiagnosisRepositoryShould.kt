package es.leanmind.boilerplace.integration

import es.leanmind.boilerplace.IntegrationTests
import es.leanmind.boilerplace.domain.interfaces.UserRepository
import es.leanmind.boilerplace.interfaces.RepositoryIntegrationTest
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
@Category(RepositoryIntegrationTest::class)
class DiagnosisRepositoryShould : IntegrationTests() {
    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun return_a_diagnosis() {
        val user = userRepository.getUserById(1)
        Assertions.assertThat(user.pets[0].name).contains("Kota")
    }
}
