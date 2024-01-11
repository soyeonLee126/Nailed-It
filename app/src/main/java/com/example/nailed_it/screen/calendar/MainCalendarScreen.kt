package com.example.nailed_it.screen.calendar

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.WorkoutRoutine
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainCalendarScreen() {
    val testWorkoutRoutine1 = WorkoutRoutine(
        routineName = "테스트 루틴",
        startTime = 0,
        endTime = 0,
    )
    val testWorkoutRoutine2 = WorkoutRoutine(
        routineName = "테스트 루틴2",
        startTime = 0,
        endTime = 0,
    )
    val testWorkoutRoutine3 = WorkoutRoutine(
        routineName = "테스트 루틴3",
        startTime = 0,
        endTime = 0,
    )

    //초기화는 현재 월로
    val calendar = Calendar.getInstance()
    val pagerState = rememberPagerState(
        initialPage = calendar.get(Calendar.MONTH),
    )
    Column(Modifier.fillMaxWidth(1f)) {
        HorizontalPager(
            pageCount = 12,
            state = pagerState,
        ) { pageIndex ->
            calendar.set(Calendar.MONTH, pageIndex)
            Column {
                MainCalendar(calendar = calendar)
                WorkoutList(listOf(testWorkoutRoutine1, testWorkoutRoutine2, testWorkoutRoutine3))
            }
        }
        AddRoutineButton(modifier = Modifier
            .align(Alignment.End)
            .padding(20.dp, 20.dp), onClick = {
            Log.e("test", "test")
        })
    }
}

@Composable
fun AddRoutineButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        modifier = modifier.size(56.dp),
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}


@Preview
@Composable
fun screenPreview() {
    MainCalendarScreen()
}

