package es.leanmind.boilerplace.domain.services

import es.leanmind.boilerplace.domain.interfaces.PetRepository
import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.infrastructure.SuccessfulCreationResponse
import es.leanmind.boilerplace.infrastructure.dto.PetDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PetService (@Autowired private val petRepository: PetRepository) {

    fun add(pet: PetDTO): SuccessfulCreationResponse {
        return petRepository.add(pet)
    }

}