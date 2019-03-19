package by.itacademy.cleancodeproject.domain.usecase.student

interface DeleteStudentUseCase {

    fun delete(id: String) : Boolean
}