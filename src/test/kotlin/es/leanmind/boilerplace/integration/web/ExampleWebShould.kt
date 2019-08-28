package es.leanmind.boilerplace.integration.web

import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.domain.models.User
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@WithMockUser("spring")
class ExampleWebShould {
    @Autowired
    lateinit var mvc: MockMvc

    val pets: List<Pet> = arrayListOf(
            Pet(1, "Kota", 1),
            Pet(2, "Wilson", 1)
    )
    val user: User = User(1, "Maik", pets)

    @Test
    fun user_print_and_have_pet() {
        val mvcResult: MvcResult = mvc.perform(MockMvcRequestBuilders.get("/users/" + user.id)
                .contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val page = mvcResult.response.contentAsString

        Assertions.assertThat(page).contains(user.name)
        Assertions.assertThat(page).contains(user.pets[0].name)
    }
}
