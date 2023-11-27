package com.example.ut5_teoria

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyBottomAppBar() {
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* do something */ }, modifier= Modifier.weight(1f)) {
                Column() {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Localized description"
                    )
                    Text(text = "Home", fontSize = 10.sp)
                }
            }
            IconButton(onClick = { /* do something */ }, modifier= Modifier.weight(1f)) {
                Column() {
                    Icon(
                        imageVector = Icons.Default.MusicNote,
                        contentDescription = "Localized description",
                    )
                    Text(text = "Play", fontSize = 10.sp)
                }

            }
            IconButton(onClick = { /* do something */ }, enabled = true, modifier= Modifier.weight(1f)) {
                Column() {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = "Localized description",
                    )
                    Text(text = "Email", fontSize = 10.sp)
                }

            }
            IconButton(onClick = { /* do something */ }, modifier= Modifier.weight(1f)) {
                Column() {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "Localized description",
                    )
                    Text(text = "Profile", fontSize = 10.sp)
                }
            }
            IconButton(onClick = { /* do something */ }, modifier= Modifier.weight(1f)) {
                Column() {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "Localized description",
                    )
                    Text(text = "Settings", fontSize = 10.sp)
                }

            }
        },
        containerColor = Color.Red,
    )
}