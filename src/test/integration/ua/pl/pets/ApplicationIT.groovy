package ua.pl.pets

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ApplicationIT extends Specification {

    def "should create context"() {
        expect:
            true
    }

}
