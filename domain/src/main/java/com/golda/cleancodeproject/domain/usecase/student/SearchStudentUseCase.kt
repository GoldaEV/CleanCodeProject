package com.golda.cleancodeproject.domain.usecase.student

import com.golda.cleancodeproject.domain.entity.student.SearchParams
import com.golda.cleancodeproject.domain.entity.student.Student

interface SearchStudentUseCase {

    fun search(params: SearchParams) : List<Student>
}