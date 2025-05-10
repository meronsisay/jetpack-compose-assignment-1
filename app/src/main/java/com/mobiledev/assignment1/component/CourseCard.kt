package com.mobiledev.assignment1.component
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobiledev.assignment1.model.Course
import com.mobiledev.assignment1.model.ListOfCourses
import com.mobiledev.assignment1.ui.theme.Assignment1Theme

@Composable
fun CourseCard(course: Course, cardColor: Color, modifier: Modifier = Modifier) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable { isExpanded = !isExpanded }
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = course.title,
                style = TextStyle(
                    color = Color(0xFF1A237E),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = course.code,
                    modifier = Modifier.weight(1f),
                    style = TextStyle(
                        color = Color(0xFF6A1B9A),
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = "${course.creditHours} Credits",
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 18.sp
                    )
                )
            }

            if (isExpanded) {
                Spacer(modifier = Modifier.height(12.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF3E5F5), shape = RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = " Description:",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF6A1B9A)
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = course.description,
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 20.sp,
                            color = Color.DarkGray
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = " Prerequisites:",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF6A1B9A)
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = course.prerequisites,
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 20.sp,
                            color = Color.DarkGray
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun CourseListScreen(courses: List<Course>, modifier: Modifier = Modifier) {
    val purples = listOf(
        Color(0xFFD1C4E9),
        Color(0xFFE1BEE7),
        Color(0xFFCE93D8),
        Color(0xFFB39DDB)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        Text(
            text = "\uD83D\uDCDD Course List",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp, start = 24.dp, bottom = 16.dp),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF6A1B9A)
            )
        )

        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(courses.size) { index ->
                val color = purples[index % purples.size]
                CourseCard(course = courses[index], cardColor = color)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CourseCardLightPreview() {
    Assignment1Theme {
        CourseCard(course = ListOfCourses[0], cardColor = Color(0xFFD1C4E9))
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CourseCardDarkPreview() {
    Assignment1Theme {
        CourseCard(course = ListOfCourses[0], cardColor = Color(0xFFB39DDB))
    }
}





