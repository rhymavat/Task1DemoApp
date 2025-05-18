package com.example.task1demoapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen() {
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    var errorTitle by remember { mutableStateOf(false) }
    var errorDescription by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD)),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(20.dp),
            tonalElevation = 8.dp,
            color = Color.White
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (!submitted) "Add New Task" else "Task Saved!",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D47A1),
                        fontSize = 24.sp
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                if (!submitted) {
                    OutlinedTextField(
                        value = taskTitle,
                        onValueChange = {
                            taskTitle = it
                            if (it.isNotBlank()) errorTitle = false
                        },
                        label = { Text("Task Title") },
                        isError = errorTitle,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (errorTitle) {
                        Text(
                            text = "Task title cannot be empty",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = taskDescription,
                        onValueChange = {
                            taskDescription = it
                            if (it.isNotBlank()) errorDescription = false
                        },
                        label = { Text("Task Description") },
                        isError = errorDescription,
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 4
                    )
                    if (errorDescription) {
                        Text(
                            text = "Task description cannot be empty",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            errorTitle = taskTitle.isBlank()
                            errorDescription = taskDescription.isBlank()
                            if (!errorTitle && !errorDescription) {
                                submitted = true
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Save Task")
                    }
                } else {
                    Text(
                        text = "Title: $taskTitle\nDescription: $taskDescription",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(onClick = {
                        // Reset to add another task
                        taskTitle = ""
                        taskDescription = ""
                        submitted = false
                    }) {
                        Text("Add Another Task")
                    }
                }
            }
        }
    }
}
