package es.leanmind.boilerplace.domain.interfaces

import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.infrastructure.SuccessfulCreationResponse
import es.leanmind.boilerplace.infrastructure.dto.PetDTO

interface PetRepository {
    fun add(pet: PetDTO): SuccessfulCreationResponse
}