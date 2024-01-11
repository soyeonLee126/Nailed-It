package com.example.nailed_it.di

import android.adservices.adselection.AddAdSelectionOverrideRequest
import com.example.domain.usecase.AddCalendarEventUsecase
import com.example.domain.usecase.CalendarRepository
import com.example.domain.usecase.GetAllEventsUsecase
import com.example.domain.usecase.GetCalendarEventUsecase
import com.example.domain.usecase.Usecases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {
    @Provides
    fun provideUsecases(repository: CalendarRepository) = Usecases(
        getAllEventsUsecase = GetAllEventsUsecase(repository = repository),
        getCalendarEventUsecase = GetCalendarEventUsecase(repository = repository),
        addCalendarEventUsecase = AddCalendarEventUsecase(repository = repository)
    )
}