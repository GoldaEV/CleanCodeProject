package com.golda.cleancodeproject.domain.usecase.student

import com.golda.cleancodeproject.domain.entity.student.Student

interface GetStudentsUseCase {

    fun get() : List<Student>
}