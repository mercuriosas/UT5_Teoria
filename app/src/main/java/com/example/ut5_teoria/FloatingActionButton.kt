package com.example.ut5_teoria

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.round

@Composable
fun MyFAB(){
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription ="Add" )
    }
}

@Composable
fun MySmallFAB() {
    SmallFloatingActionButton(
        onClick = { /*TODO*/  },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary,
        shape = RoundedCornerShape(50)
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }
}

@Composable
fun MyLargeFAB() {
    LargeFloatingActionButton(
        onClick = { /*TODO*/  },
        shape = CircleShape,
        contentColor = Color(0xFFF44336)
    ) {
        Icon(Icons.Filled.Add, "Large floating action button")
    }
}

@Composable
fun MyExtendedFAB() {
    ExtendedFloatingActionButton(
        onClick = { /*TODO*/ },
        icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
        text = { Text(text = "Extended FAB") },
    )
}