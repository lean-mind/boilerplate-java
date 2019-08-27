package es.leanmind.boilerplace.infrastructure.dto

data class UserDTO(
        val id: Int,
        val name: String,
        val pets: List<String>
)