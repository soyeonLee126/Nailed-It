package com.example.nailed_it.screen.calendar

import DayOfWeek.SAT
import DayOfWeek.SUN
import DayOfWeek.dayOfWeekList
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Calendar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainCalendarScreen() {
    //현재 달력
    val calendar = Calendar.getInstance()
    HorizontalPager(
        pageCount = 12,
    ) { pageIndex ->
        calendar.set(Calendar.MONTH, pageIndex)
        MainCalendar(calendar = calendar)
    }
}

@Composable
fun MainCalendar(calendar: Calendar) {
    val mutableCalendar = calendar
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val lastDate = calendar.getActualMaximum(Calendar.DATE)
    val currentCalendar = Calendar.getInstance()
    val currentDate =
        if (month == currentCalendar.get(Calendar.MONTH) && year == currentCalendar.get(Calendar.YEAR)) calendar.get(
            Calendar.DATE
        ) else 0
    mutableCalendar.set(Calendar.DATE, 1)
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 2
    Column {
        MonthTitle(month = "${year}년 ${month + 1}월")
        Column(modifier = Modifier.padding(10.dp)) {
            DayOfWeekList()
            DateList(
                lastDate = lastDate,
                firstDayOfWeek = firstDayOfWeek,
                currentDate = currentDate
            )
        }
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
fun DayOfWeekList() {
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
fun DateList(lastDate: Int, firstDayOfWeek: Int, currentDate: Int) {
    var currentDay = 1
    repeat(6) { // 최대 6주까지만 표시
        Row {
            repeat(7) {
                if ((it < firstDayOfWeek && currentDay == 1) || currentDay > lastDate) {
                    Spacer(modifier = Modifier.size(50.dp, 0.dp))
                } else {
                    DateItem(
                        modifier = if (currentDate == currentDay) Modifier.background(Color.Black) else Modifier,
                        date = currentDay
                    )
                    currentDay++
                }
            }
        }
    }
}

@Composable
fun DateItem(date: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .size(50.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = date.toString(), textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun CalendarItemPreview() {
    MainCalendarScreen()
}
