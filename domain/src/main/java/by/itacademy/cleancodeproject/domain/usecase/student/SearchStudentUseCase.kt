package by.itacademy.cleancodeproject.domain.usecase.student

import by.itacademy.cleancodeproject.domain.entity.student.SearchParams
import by.itacademy.cleancodeproject.domain.entity.student.Student

interface SearchStudentUseCase {

    fun search(params: SearchParams) : List<Student>
}