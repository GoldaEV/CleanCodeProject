package by.itacademy.cleancodeproject.domain.entity.student

import by.itacademy.cleancodeproject.domain.entity.DomainEntity

class SearchParams(
    val name: String = "",
    val age: Int = 0
) : DomainEntity
