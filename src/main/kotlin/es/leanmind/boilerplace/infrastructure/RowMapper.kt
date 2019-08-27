package es.leanmind.boilerplace.infrastructure

import es.leanmind.boilerplace.domain.models.Pet
import es.leanmind.boilerplace.domain.models.User
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class RowMapper {
    fun getUser(): RowMapper<User> {
        return RowMapper { resultSet: ResultSet, _: Int ->
            User(
                resultSet.getInt("id"),
                resultSet.getString("name")
            )
        }
    }

    fun getPets(): RowMapper<Pet> {
        return RowMapper { resultSet: ResultSet, _: Int ->
            Pet(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("user_id")
            )
        }
    }
}