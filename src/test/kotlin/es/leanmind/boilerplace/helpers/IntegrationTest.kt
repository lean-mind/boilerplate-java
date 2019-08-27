package es.leanmind.boilerplace.helpers

import es.leanmind.boilerplace.Configuration
import org.junit.After
import org.junit.Before
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

open class IntegrationTest {
    @Before
    @Throws(SQLException::class)
    fun createDatabase() {
        try {
            println("Connecting to Database...")
            val connection: Connection = DriverManager.getConnection(
                    Configuration.connectionTestDatabase,
                    Configuration.dbUser,
                    Configuration.dbPassword
            )
            println("Connected to Database")
            val statement = connection.createStatement()
            println("Dropping old database...")
            statement.executeUpdate("DROP DATABASE IF EXISTS " + Configuration.testDb)
            println("Creating database...")
            statement.executeUpdate("CREATE DATABASE " + Configuration.testDb + " WITH TEMPLATE " + Configuration.productionDb + " OWNER " + Configuration.dbUser)
            println("Database created")
        } catch(exception: Exception) {
            System.err.println("Error creating database: " + exception.message)
        }
    }

    @After
    @Throws(SQLException::class)
    fun dropDatabase() {
        try {
            println("Connecting to Database...")
            val connection: Connection = DriverManager.getConnection(
                    Configuration.connectionTestDatabase,
                    Configuration.dbUser,
                    Configuration.dbPassword
            )
            println("Connected to Database")
            val statement = connection.createStatement()
            println("Dropping old database...")
            statement.executeUpdate("DROP DATABASE IF EXISTS " + Configuration.testDb)
            println("Database dropped")
        } catch(exception: Exception) {
            System.err.println("Error dropping database: " + exception.message)
        }
    }

    @Before
    fun setUpCascade() {
        flushDatabase()
    }

    @After
    fun tearDownCascade() {
        flushDatabase()
    }

    @Throws(SQLException::class)
    private fun flushDatabase() {
        println("Flushing database...")
        val connection: Connection = DriverManager.getConnection(
                Configuration.connectionTestDatabase,
                Configuration.dbUser,
                Configuration.dbPassword
        )
        connection.autoCommit = false
        val statement: Statement = connection.createStatement()
        statement.executeUpdate("DELETE FROM establishments")
        connection.commit()
        println("Database flushed")
    }
}