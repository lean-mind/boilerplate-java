package es.leanmind.boilerplace.infrastructure.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class PetDTO (
        val name: String,
        val userId: Int
)