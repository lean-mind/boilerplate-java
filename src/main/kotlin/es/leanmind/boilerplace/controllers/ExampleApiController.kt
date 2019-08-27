package es.leanmind.boilerplace.controllers

import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.domain.models.User
import es.leanmind.boilerplace.domain.services.PetService
import es.leanmind.boilerplace.domain.services.UserService
import es.leanmind.boilerplace.infrastructure.SuccessfulCreationResponse
import es.leanmind.boilerplace.infrastructure.dto.PetDTO
import es.leanmind.boilerplace.infrastructure.dto.UserDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class ExampleApiController {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var petService: PetService

    @GetMapping("/api/users/{userId}")
    fun getUserById(@PathVariable userId: Int): UserDTO {
        val user: User = userService.getUserById(userId)
        return UserDTO(
                user.id,
                user.name,
                user.pets.map {pet ->
                    pet.name
                }
        )
    }

    @PostMapping("/api/pets")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody pet: PetDTO): SuccessfulCreationResponse? {
        return SuccessfulCreationResponse(petService.add(pet).id)
    }

}