package com.mobiledev.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.mobiledev.assignment1.component.CourseListScreen
import com.mobiledev.assignment1.model.ListOfCourses
import com.mobiledev.assignment1.ui.theme.Assignment1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CourseListScreen(
                        courses = ListOfCourses,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(
//        color = MaterialTheme.colorScheme.primary
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )
//    }
//
//}

