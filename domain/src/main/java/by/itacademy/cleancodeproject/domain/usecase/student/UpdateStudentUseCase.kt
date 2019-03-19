package by.itacademy.cleancodeproject.domain.usecase.student

import by.itacademy.cleancodeproject.domain.entity.student.Student

interface UpdateStudentUseCase {

    fun update(student: Student) : Boolean
}