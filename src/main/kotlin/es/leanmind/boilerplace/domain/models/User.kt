package es.leanmind.boilerplace.domain.models

class User (
        val id: Int,
        val name: String,
        val pets: List<Pet>
) {
    constructor(
            id: Int,
            name: String
    ) : this (
            id = id,
            name = name,
            pets = ArrayList<Pet>()
    )
}