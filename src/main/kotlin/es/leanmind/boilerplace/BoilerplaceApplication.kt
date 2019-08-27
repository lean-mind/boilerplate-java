package es.leanmind.boilerplace

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BoilerplaceApplication

fun main(args: Array<String>) {
	runApplication<BoilerplaceApplication>(*args)
}
