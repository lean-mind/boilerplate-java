@file:Suppress("ASSIGNING_SINGLE_ELEMENT_TO_VARARG_IN_NAMED_FORM_ANNOTATION")

package es.leanmind.boilerplace.integration.api

import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.domain.models.User
import es.leanmind.boilerplace.domain.services.UserService
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@WithMockUser("spring")
class ExampleApiShould {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var userServiceStub: UserService

    val pets: List<Pet> = arrayListOf(
            Pet(0, "Musifu", 1),
            Pet(2, "Wilson", 1)
    )
    val user: User = User(1, "Noe", pets)

    @Test
    fun parse_retrieved_user_to_json() {
        val expectedPets = JSONArray()
        pets.map { pet -> expectedPets.put(pet.name) }

        val expectedUser = JSONObject()
        expectedUser.put("id", user.id)
        expectedUser.put("name", user.name)
        expectedUser.put("pets", expectedPets)

        given(userServiceStub.getUserById(user.id)).willReturn(user)

        mvc.perform(get("/api/users/" + user.id))
                .andExpect(status().isOk)
                .andExpect(content().json(expectedUser.toString()))
    }

}