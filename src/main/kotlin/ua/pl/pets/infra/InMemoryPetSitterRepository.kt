package ua.pl.pets.infra

import org.springframework.stereotype.Repository
import ua.pl.pets.domain.PetSitter
import ua.pl.pets.domain.PetSitterRepository

@Repository
class InMemoryPetSitterRepository : PetSitterRepository{

    val map: HashMap<Long, PetSitter> = HashMap()

    init {
        for (i in 1L..20L){
            map[i] = PetSitter(i, "Pet Sitter $i")
        }
    }


    override fun findById(id: Long): PetSitter? {
        return map[id]
    }

    override fun findAll(): List<PetSitter> {
        return map.entries.map { entry -> entry.value }
    }

}