package es.leanmind.boilerplace.infrastructure.repositories

import es.leanmind.boilerplace.domain.interfaces.UserRepository
import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.domain.models.User
import es.leanmind.boilerplace.infrastructure.RowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class PostgresUserRepository : UserRepository {

    @Autowired
    var jdbcTemplate: JdbcTemplate = JdbcTemplate()

    override fun getUserById(userId: Int): User {

        val user: User = jdbcTemplate.query(
            "SELECT id, name " +
                 "FROM users " +
                 "WHERE id = ?",
            arrayOf(userId),
            RowMapper().getUser()
        ).first()

        val pets: List<Pet> = jdbcTemplate.query(
            "SELECT id, name, user_id " +
                 "FROM pets " +
                 "WHERE user_id = ?",
            arrayOf(userId),
            RowMapper().getPets()
        )

        return User(user.id, user.name, pets)
    }

}