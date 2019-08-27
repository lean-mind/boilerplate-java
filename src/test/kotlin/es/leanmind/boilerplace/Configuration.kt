package es.leanmind.boilerplace

import es.leanmind.boilerplace.helpers.Properties

class Configuration {
    companion object {
        val browser: String = "chrome" //could be "firefox"
        val webUrl: String = "http://localhost:" + Properties.WEB_SERVER_PORT
        val loginUrl: String = "/login"
        val username: String = "name"
        val password: String = "12345"
        val createPatientUrl: String = "/patients/create"
        val patientName: String = "Pumuki"
        val chromeDriverPath: String = "./src/test/chromedriver"
        val firefoxDriverPath: String = "./src/test/geckodriver"
        val dbUser: String = "leanmind"
        val dbPassword: String = "12345"
        val productionDb: String = "boilerplace-kotlin-react"
        val connectionBaseUrl: String = "jdbc:postgresql://localhost:5432/"
        val testDb: String = productionDb + "-test"
        val connectionTestDatabase: String = connectionBaseUrl + testDb + "?name=" + dbUser + "&password=" + dbPassword
    }
}