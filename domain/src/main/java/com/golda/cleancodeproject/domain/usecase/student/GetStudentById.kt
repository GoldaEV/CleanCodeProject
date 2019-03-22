package com.golda.cleancodeproject.domain.usecase.student

import com.golda.cleancodeproject.domain.entity.student.Student

interface GetStudentById {

    fun get(id: String) : Student
}