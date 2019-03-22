package com.golda.cleancodeproject.domain.entity.student

import com.golda.cleancodeproject.domain.entity.DomainEntity

data class Student(
    val id: String,
    val name: String,
    val age: Int,
    val imageUrl: String
) : DomainEntity
