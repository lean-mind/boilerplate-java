//package es.leanmind.boilerplace.integration
//
//import assertk.assertThat
//import es.leanmind.boilerplace.IntegrationTests
//import es.leanmind.boilerplace.interfaces.RepositoryIntegrationTest
//import org.junit.Test
//import org.junit.experimental.categories.Category
//import org.junit.runner.RunWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.junit4.SpringRunner
//
//@SpringBootTest
//@RunWith(SpringRunner::class)
//@Category(RepositoryIntegrationTest::class)
//class DiagnosisRepositoryShould : IntegrationTests() {
//    @Autowired
//    lateinit var diagnosisRepository: DiagnosisRepository
//
//    @Test
//    fun return_a_diagnosis() {
//        add_diagnosis()
//        val diagnosis = diagnosisRepository.searchByName("Urate").first()
//        assertThat(diagnosis.toString().toLowerCase()).contains("urate stones")
//    }
//}