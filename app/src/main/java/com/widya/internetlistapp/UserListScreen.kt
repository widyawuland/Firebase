package com.widya.internetlistapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserListScreen() {
    val viewModel: UserViewModel = viewModel()

    if (viewModel.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(viewModel.userList) { user ->
                Card(
                    elevation = 8.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "ID:",
                            style = MaterialTheme.typography.caption,
                            color = Color.Blue
                        )
                        Text(
                            text = user.id.toString(),
                            style = MaterialTheme.typography.body1
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Nama:",
                            style = MaterialTheme.typography.caption,
                            color = Color.Blue
                        )
                        Text(
                            text = user.name,
                            style = MaterialTheme.typography.body1
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Email:",
                            style = MaterialTheme.typography.caption,
                            color = Color.Blue
                        )
                        Text(
                            text = user.email,
                            style = MaterialTheme.typography.body1
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Jenis Kelamin:",
                            style = MaterialTheme.typography.caption,
                            color = Color.Blue
                        )
                        Text(
                            text = user.gender.replaceFirstChar { it.uppercase() },
                            style = MaterialTheme.typography.body1
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Status:",
                            style = MaterialTheme.typography.caption,
                            color = Color.Blue
                        )
                        Text(
                            text = user.status.replaceFirstChar { it.uppercase() },
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}