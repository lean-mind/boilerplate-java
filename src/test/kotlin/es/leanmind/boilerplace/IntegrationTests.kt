package es.leanmind.boilerplace

import org.junit.After
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import java.sql.Statement

open class IntegrationTests {
//    @Autowired
//    var jdbcTemplate: JdbcTemplate = JdbcTemplate()
//
//    @Before
//    @After
//    open fun tearDown() {
//        jdbcTemplate.update("DELETE FROM patients")
//        jdbcTemplate.update("DELETE FROM diagnoses")
//        jdbcTemplate.update("DELETE FROM cases")
//        jdbcTemplate.update("DELETE FROM notes")
//    }
//
//    fun add_patient() : Patient {
//        jdbcTemplate.update("INSERT INTO patients(CHIP_ID, NAME, ALTERNATIVE_NAME, SPECIE, BREED, IS_CROSSBREED, GENDER, BIRTHDATE, JSON) VALUES (?,?,?,?,?,?,?,?::TIMESTAMP,?)",
//            "12345678",
//            "Musito",
//            "Mus",
//                1,
//                1,
//                false,
//            "MALE",
//            "2015-01-01 00:00:00",
//            "{}"
//        )
//
//        val patients: MutableList<Patient> = ArrayList<Patient>()
//        val rows = jdbcTemplate.queryForList("SELECT * FROM patients")
//
//        rows.forEach {
//            patients.add(Patient(
//                it.get("ID") as Number,
//                it.get("CHIP_ID").toString(),
//                it.get("NAME").toString(),
//                it.get("ALTERNATIVE_NAME").toString(),
//                    it.get("SPECIE") as Int,
//                    it.get("BREED") as Int,
//                    it.get("IS_CROSSBREED") as Boolean,
//                it.get("GENDER").toString(),
//                it.get("BIRTHDATE").toString(),
//                it.get("JSON").toString()
//            ))
//        }
//
//        return patients[0]
//    }
//
//    fun add_diagnosis() : Diagnosis {
//        jdbcTemplate.update("INSERT INTO diagnoses (NAME, DESCRIPTION, JSON) VALUES (?,?,?)",
//                "Urate stones - Ureter",
//                "Mineral mass in the ureter, which may or may not have originated in the kidney and traveled down into the ureter",
//                "{}"
//        )
//
//        val diagnoses: MutableList<Diagnosis> = ArrayList<Diagnosis>()
//        val rows = jdbcTemplate.queryForList("SELECT * FROM diagnoses")
//
//        rows.forEach {
//            diagnoses.add(Diagnosis(
//                    it.get("ID") as Number,
//                    it.get("NAME").toString(),
//                    it.get("DESCRIPTION").toString(),
//                    it.get("JSON").toString()
//            ))
//        }
//        return diagnoses[0]
//    }
//
//    fun add_case(): Case {
//        val keyHolder: KeyHolder = GeneratedKeyHolder()
//        val patient = add_patient()
//        val diagnosis = add_diagnosis()
//
//        jdbcTemplate.update({ connection ->
//            val ps = connection
//                    .prepareStatement(
//                            "INSERT INTO cases (patient_id, diagnosis_id) VALUES (?,?)",
//                            Statement.RETURN_GENERATED_KEYS)
//            ps.setInt(1, patient.id().toInt())
//            ps.setInt(2, diagnosis.id().toInt())
//            ps
//        }, keyHolder)
//
//        val caseId = keyHolder.keys?.get("id") as Number
//
//        jdbcTemplate.update("" +
//                "INSERT INTO notes (case_id, content, is_public) VALUES (?,?,?)",
//                caseId, "Irrelevant note", true)
//
//        val cases: MutableList<Case> = ArrayList<Case>()
//        val rows = jdbcTemplate.queryForList("SELECT * FROM cases")
//
//        rows.forEach {
//            cases.add(Case(
//                    it.get("ID") as Number,
//                    patient,
//                    diagnosis,
//                    ""
//            ))
//        }
//
//        return cases[0]
//    }
}