package by.itacademy.cleancodeproject.domain.entity.student

import by.itacademy.cleancodeproject.domain.entity.DomainEntity

data class CreateStudent(
    val name: String,
    val age: Int,
    val imageUrl: String
) : DomainEntity
