package com.example.nailed_it.screen.calendar

import DayOfWeek.SAT
import DayOfWeek.SUN
import DayOfWeek.THU
import DayOfWeek.dayOfWeekList
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainCalendar() {
    Column {
        MonthTitle(month = "2021년 8월")
        DateList(lastDate = 31, firstDayOfWeek = THU)
    }
}

@Composable
fun MonthTitle(month: String) {
    Text(
        text = month,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(10.dp)
    )
}

@Composable
fun DateList(lastDate: Int, firstDayOfWeek: String) {
    val firstDay = dayOfWeekList.indexOf(firstDayOfWeek)

    Column(modifier = Modifier.padding(10.dp)) {
        DayOfWeekItem()

        var currentDay = 1

        repeat(6) { // 최대 6주까지만 표시
            Row {
                repeat(7) {
                    if ((it < firstDay && currentDay == 1) || currentDay > lastDate) {
                        Spacer(modifier = Modifier.size(60.dp, 0.dp))
                    } else {
                        CalendarItem(currentDay)
                        currentDay++
                    }
                }
            }
        }
    }
}

@Composable
fun DayOfWeekItem() {
    val modifierForText = Modifier
        .size(50.dp)
    Row() {
        dayOfWeekList.forEach {
            if (it != SUN && it != SAT) Text(
                text = it,
                textAlign = TextAlign.Center,
                modifier = modifierForText
            )
            else Text(
                text = it,
                textAlign = TextAlign.Center,
                modifier = modifierForText,
                color = Color.Red
            )
        }
    }
}

@Composable
fun CalendarItem(date: Int) {
    Card(
        modifier = Modifier
            .size(40.dp)
            .clickable { }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(1f),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = date.toString(), textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun CalendarItemPreview() {
    MainCalendar()
}
