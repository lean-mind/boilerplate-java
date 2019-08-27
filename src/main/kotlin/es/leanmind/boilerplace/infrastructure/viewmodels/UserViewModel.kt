package es.leanmind.boilerplace.infrastructure.viewmodels

import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.domain.models.User

class UserViewModel (
        val id: Int,
        val name: String,
        val pets: List<Pet>
) {
    constructor(
            user: User
    ) : this (
            id = user.id,
            name = user.name,
            pets = user.pets
    )
}