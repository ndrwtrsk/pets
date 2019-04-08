package ua.pl.pets.infra

import spock.lang.Specification
import spock.lang.Subject

class InMemoryPetSitterRepositoryUT extends Specification {

    @Subject
    private InMemoryPetSitterRepository repository = new InMemoryPetSitterRepository()

    def "should return 20 pet sitters"() {
        expect:
            repository.findAll().size() == 20
    }

}
