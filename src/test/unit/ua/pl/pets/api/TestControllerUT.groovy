package ua.pl.pets.api

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Subject

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class TestControllerUT extends Specification {

    @Subject
    private TestController controller = new TestController()

    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
            .build()

    def "should return test object"() {
        expect:
        mockMvc.perform(get('/api/test'))
                .andExpect(status().isOk())
    }
}
