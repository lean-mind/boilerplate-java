//package es.leanmind.boilerplace.unit
//
//import junit.framework.Assert.assertTrue
//import org.assertj.core.api.AssertionsForClassTypes.assertThat
//import org.junit.Test
//
//class BreedShould {
//    @Test
//    fun be_related_with_an_specie() {
//        assertThat(Breed.AmericanHairlessTerrier.specie).isEqualTo(Specie.Dog)
//    }
//
//    @Test
//    fun get_all_breeds_of_an_specie() {
//        assertTrue(Breed.allBySpecie(Specie.Cat).contains(Breed.Abyssinian))
//    }
//
//    @Test
//    fun get_a_breed_by_id() {
//        assertThat(Breed.byId(40)).isEqualTo(Breed.Manx)
//    }
//}