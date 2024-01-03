package com.example.domain.usecase

import javax.inject.Inject

class GetAllEventsUsecase @Inject constructor(private val repository: CalendarRepository) {
    suspend operator fun invoke(span: IntRange) = repository.getAllCalendarEvnets(span)
}