package ua.pl.pets.domain

interface PetSitterRepository {
    fun findById(id: Long): PetSitter?
    fun findAll(): List<PetSitter>
}