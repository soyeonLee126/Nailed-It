package com.example.domain.usecase

import com.example.domain.model.CalendarEvent
import com.example.domain.model.WorkoutRoutine

interface CalendarRepository {
    fun addWorkoutRoutine(routine: WorkoutRoutine)
    suspend fun deleteWorkoutRoutine(routine: WorkoutRoutine)
    suspend fun addAlarm(routine: WorkoutRoutine)
    suspend fun deleteAlarm(routine: WorkoutRoutine)
    suspend fun getAllCalendarEvnets(span: IntRange): List<CalendarEvent>
    fun addCalendarEvent(event: CalendarEvent)
    suspend fun getCalendarEvent(seq: Long): CalendarEvent
    suspend fun deleteCalendarEvent(event: CalendarEvent)
}