package es.leanmind.boilerplace.controllers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.domain.models.User
import es.leanmind.boilerplace.domain.services.PetService
import es.leanmind.boilerplace.domain.services.UserService
import es.leanmind.boilerplace.infrastructure.viewmodels.UserViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletRequest

@Controller
class ExampleController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/users/{userId}")
    fun main(model: Model, @PathVariable userId: Int): String {
        val user: User = userService.getUserById(userId)
        val userViewModel = UserViewModel(user)

        val mapper = jacksonObjectMapper()
        model.addAttribute("userJSON", mapper.writeValueAsString(userViewModel))
        model.addAttribute("users", userViewModel)
        return "users/edit"
    }
}