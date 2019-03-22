package com.golda.cleancodeproject.domain.usecase.student

import com.golda.cleancodeproject.domain.entity.student.CreateStudent

interface CreateStudentUseCase {

    fun create(student: CreateStudent) : Boolean
}