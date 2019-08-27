//package es.leanmind.boilerplace.integration
//
//import es.leanmind.boilerplace.IntegrationTests
//import org.assertj.core.api.Assertions
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.http.MediaType
//import org.springframework.security.test.context.support.WithMockUser
//import org.springframework.test.context.junit4.SpringRunner
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.MvcResult
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers
//
//@SpringBootTest
//@RunWith(SpringRunner::class)
//@AutoConfigureMockMvc
//@WithMockUser("spring")
//class ExampleControllerShould : IntegrationTests() {
//    @Autowired
//    lateinit var mvc: MockMvc
//
//    @Test
//    fun return_the_patient_to_be_edited() {
//        val patient: Patient = add_patient()
//        val mvcResult: MvcResult = mvc.perform(MockMvcRequestBuilders.get("/patient/edit/" + patient.id())
//                .contentType(MediaType.TEXT_HTML))
//                .andExpect(MockMvcResultMatchers.status().isOk)
//                .andReturn()
//        val page = mvcResult.response.contentAsString
//
//        Assertions.assertThat(page).contains(patient.id().toString())
//        Assertions.assertThat(page).contains(patient.chipId())
//        Assertions.assertThat(page).contains(patient.name())
//    }
//
//    @Test
//    fun return_the_parent_of_the_patient_to_be_edited() {
//        val patient: Patient = add_patient()
//        val mvcResult: MvcResult = mvc.perform(MockMvcRequestBuilders.get("/patient/edit/" + patient.id())
//                .contentType(MediaType.TEXT_HTML))
//                .andExpect(MockMvcResultMatchers.status().isOk)
//                .andReturn()
//        val page = mvcResult.response.contentAsString
//
//        Assertions.assertThat(page).contains(patient.id().toString())
//        Assertions.assertThat(page).contains(patient.chipId())
//        Assertions.assertThat(page).contains(patient.name())
//
//        // --> editPatientViewModel con los datos del formulario
//    }
//
//    @Test
//    fun list_all_patients(){
//        val patient: Patient = add_patient()
//        val mvcResult: MvcResult = mvc.perform(MockMvcRequestBuilders.get("/patient/list")
//                .contentType(MediaType.TEXT_HTML))
//                .andExpect(MockMvcResultMatchers.status().isOk)
//                .andReturn()
//        val page = mvcResult.response.contentAsString
//
//        Assertions.assertThat(page).contains(patient.name())
//    }
//}