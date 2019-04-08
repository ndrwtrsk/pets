package ua.pl.pets.api

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.pl.pets.api.query.PetSitterDto
import ua.pl.pets.usecases.FindPetSitters

@RestController
@RequestMapping("/api/pet_sitters")
class PetSitterController(private val findPetSitters: FindPetSitters) {

    @GetMapping
    @ApiOperation("Find all pet sitters", responseContainer = "list", code = 200)
    fun findAll(): List<PetSitterDto> {
        return findPetSitters.findAll().map { petSitter -> PetSitterDto(petSitter.id, petSitter.name) }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): PetSitterDto {
        return findPetSitters.findById(id).let { petSitter -> PetSitterDto(petSitter.id, petSitter.name) }
    }

}