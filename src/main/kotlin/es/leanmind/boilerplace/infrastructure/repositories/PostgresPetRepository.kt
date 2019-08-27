package es.leanmind.boilerplace.infrastructure.repositories

import es.leanmind.boilerplace.domain.interfaces.PetRepository
import es.leanmind.boilerplace.infrastructure.SuccessfulCreationResponse
import es.leanmind.boilerplace.infrastructure.dto.PetDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository
import java.sql.Statement

@Repository
class PostgresPetRepository: PetRepository {

    @Autowired
    var jdbcTemplate: JdbcTemplate = JdbcTemplate()

    override fun add(pet: PetDTO): SuccessfulCreationResponse {
        val keyHolder: KeyHolder = GeneratedKeyHolder()

        jdbcTemplate.update({ connection ->
            val ps = connection
                    .prepareStatement(
                            "INSERT INTO pets (name, user_id) VALUES (?,?)",
                            Statement.RETURN_GENERATED_KEYS)
            ps.setString(1, pet.name)
            ps.setInt(2, pet.userId)
            ps
        }, keyHolder)

        val petId: Int = (keyHolder.keys?.get("id") as Int?) ?: 0

        return SuccessfulCreationResponse(petId)
    }

}