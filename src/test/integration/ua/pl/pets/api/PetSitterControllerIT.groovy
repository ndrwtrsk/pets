package ua.pl.pets.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest
class PetSitterControllerIT extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "should find specific pet sitter"() {
        given:
            def id = 10

        expect:
            mockMvc.perform(get("/api/pet_sitters/$id"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath('$.id').value(id))
                    .andExpect(jsonPath('$.name').value(not(isEmptyOrNullString())))
    }

    def "should return all available pet sitters"() {
        expect:
            mockMvc.perform(get("/api/pet_sitters"))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$', hasSize(20)))
    }

}
