package com.example.domain.usecase

import javax.inject.Inject

class GetCalendarEventUsecase @Inject constructor(private val repository: CalendarRepository) {
    suspend operator fun invoke(seq: Long) = repository.getCalendarEvent(seq)
}