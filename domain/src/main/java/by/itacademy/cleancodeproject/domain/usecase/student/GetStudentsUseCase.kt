package by.itacademy.cleancodeproject.domain.usecase.student

import by.itacademy.cleancodeproject.domain.entity.student.Student

interface GetStudentsUseCase {

    fun get() : List<Student>
}