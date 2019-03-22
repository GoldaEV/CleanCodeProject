package com.golda.cleancodeproject.domain.entity.student

import com.golda.cleancodeproject.domain.entity.DomainEntity

class SearchParams(
    val name: String = "",
    val age: Int = 0
) : DomainEntity
