package com.example.ut5_teoria

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


data class ModalDrawer(
    val title: String,
    val selectedIcon:ImageVector,
    val unslectecIcon:ImageVector,
    val badgedCount:Int? =null
)


@Composable
fun MyModalDrawer() {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Opción 1", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Opción 2", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Opción 3", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        Text(text = "Opción 4", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
    }
}
