package com.example.domain.usecase

data class Usecases(
    val addCalendarEventUsecase: AddCalendarEventUsecase,
    val getAllEventsUsecase: GetAllEventsUsecase,
    val getCalendarEventUsecase: GetCalendarEventUsecase
)
