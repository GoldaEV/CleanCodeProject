package by.itacademy.cleancodeproject.domain.usecase.student

import by.itacademy.cleancodeproject.domain.entity.student.CreateStudent

interface CreateStudentUseCase {

    fun create(student: CreateStudent) : Boolean
}