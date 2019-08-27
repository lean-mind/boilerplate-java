package es.leanmind.boilerplace.infrastructure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DatabaseSeeder {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @PostConstruct
    fun seed() {
        seedUsersTable()
        seedPetsTable()
    }

    private fun seedUsersTable() {
        val users: ArrayList<Array<String>> = ArrayList()
        users.add(arrayOf("Maik"))

        for (user in users) {
            jdbcTemplate.update(
                    "INSERT INTO users(name) VALUES (?)",
                    user[0])
        }
    }


    private fun seedPetsTable() {
        val pets: ArrayList<Array<Any>> = ArrayList()
        pets.add(arrayOf("Kota", 1))
        pets.add(arrayOf("Wilson", 1))

        for (pet in pets) {
            jdbcTemplate.update(
                    "INSERT INTO pets(name, user_id) VALUES (?,?)",
                    pet[0], pet[1])
        }
    }

    fun down() {
        jdbcTemplate.update("DELETE FROM users")
        jdbcTemplate.update("DELETE FROM pets")
    }
}
