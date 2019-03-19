package by.itacademy.cleancodeproject.domain.usecase.student

import by.itacademy.cleancodeproject.domain.entity.student.Student

interface GetStudentById {

    fun get(id: String) : Student
}