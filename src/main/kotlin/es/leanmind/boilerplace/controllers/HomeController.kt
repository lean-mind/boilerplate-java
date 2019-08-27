package es.leanmind.boilerplace.controllers

import es.leanmind.boilerplace.infrastructure.Roles
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.servlet.view.RedirectView


@Controller
class HomeController {
    @GetMapping("/")
    fun main(model: Model): String {
        val auth = SecurityContextHolder
                .getContext()
                .authentication.authorities
                .first().authority
        val isAuthenticated = auth == Roles.AuthenticatedUser
        model.addAttribute("isAuthenticated", isAuthenticated)
        return "index"
    }

    @GetMapping("/login")
    fun login(): RedirectView {
        return RedirectView("/")
    }
}