package com.example.nailed_it.screen.calendar

import DayOfWeek
import DayOfWeek.FRI
import DayOfWeek.MON
import DayOfWeek.SAT
import DayOfWeek.SUN
import DayOfWeek.THU
import DayOfWeek.TUE
import DayOfWeek.WED
import DayOfWeek.dayOfWeekList
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

class MainCalendar {
}

@Composable
fun CalendarList(dateRange: IntRange, firstDayOfWeek: String) {
    val firstDay = dayOfWeekList.indexOf(firstDayOfWeek)
    Column {
        DayOfWeekItem()
        Row() {
            //첫 요일 전까지 빈 박스 생성
            for (i in 1..firstDay) {
                Spacer(modifier = Modifier.size(50.dp))
            }
            //첫 주는 생성, 날짜 넘으면 넘김
            dateRange.forEach { date ->
                CalendarItem(date = date)
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}

@Composable
fun DayOfWeekItem() {
    val modifierForText = Modifier
        .padding(10.dp)
        .size(27.dp)
    Row() {
        Text(text = MON, textAlign = TextAlign.Center, modifier = modifierForText)
        Text(text = TUE, textAlign = TextAlign.Center, modifier = modifierForText)
        Text(text = WED, textAlign = TextAlign.Center, modifier = modifierForText)
        Text(text = THU, textAlign = TextAlign.Center, modifier = modifierForText)
        Text(text = FRI, textAlign = TextAlign.Center, modifier = modifierForText)
        Text(
            text = SAT,
            textAlign = TextAlign.Center,
            modifier = modifierForText,
            color = Color.Red
        )
        Text(
            text = SUN,
            textAlign = TextAlign.Center,
            modifier = modifierForText,
            color = Color.Red
        )
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
    CalendarList(1..30, TUE)
}
