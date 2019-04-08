package ua.pl.pets.usecases

import org.springframework.stereotype.Service
import ua.pl.pets.domain.PetSitter
import ua.pl.pets.domain.PetSitterRepository
import ua.pl.pets.domain.exceptions.PetSitterNotFound

@Service
class FindPetSitters(private val petSitterRepository: PetSitterRepository) {

    fun findById(id: Long): PetSitter {
        return petSitterRepository.findById(id)?: throw PetSitterNotFound()
    }

    fun findAll(): List<PetSitter> {
        return petSitterRepository.findAll()
    }

}