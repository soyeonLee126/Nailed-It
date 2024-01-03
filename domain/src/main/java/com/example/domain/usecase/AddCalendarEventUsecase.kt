package com.example.domain.usecase

import com.example.domain.model.CalendarEvent
import javax.inject.Inject

class AddCalendarEventUsecase @Inject constructor(private val repository: CalendarRepository) {
    suspend operator fun invoke(event: CalendarEvent) = repository.addCalendarEvent(event)
}