package com.example.nailed_it.screen.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.WorkoutRoutine
import com.example.nailed_it.R

@Composable
fun WorkoutList(workOutRoutineList: List<WorkoutRoutine>) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(1f)
    ) {
        Column(modifier = Modifier.padding(20.dp, 20.dp)) {
            Text(
                text = stringResource(id = R.string.todays_routine),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(0.dp, 10.dp))
            workOutRoutineList.forEach {
                WorkoutItem(it)
            }
        }
    }
}

@Composable
fun WorkoutItem(workOutRoutine: WorkoutRoutine) {
    Column {
        Text(text = "${workOutRoutine.routineName} : ${workOutRoutine.startTime} ~ ${workOutRoutine.endTime}")
    }
}

@Preview
@Composable
fun WorkoutItemPreview() {
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
    WorkoutList(listOf(testWorkoutRoutine1, testWorkoutRoutine2, testWorkoutRoutine3))
}