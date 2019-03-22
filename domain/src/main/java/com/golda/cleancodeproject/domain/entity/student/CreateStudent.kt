package com.golda.cleancodeproject.domain.entity.student

import com.golda.cleancodeproject.domain.entity.DomainEntity

data class CreateStudent(
    val name: String,
    val age: Int,
    val imageUrl: String
) : DomainEntity
