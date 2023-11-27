package com.example.ut5_teoria

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarSmall() {
    TopAppBar(
        // Título de la barra superior
        title = {

            Text(text = "TopAppBar")
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarCenter() {
    val contextForToast = LocalContext.current.applicationContext
    CenterAlignedTopAppBar(// Título de la barra superior
        title = {
            Row(Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.dragonball),
                    contentDescription = "Dragon Ball",
                    Modifier.size(100.dp)
                )
                Text(text = "TopAppBar")
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                //MyDrawerState.open()
                //Toast.makeText(contextForToast, "Nav Icon Click", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Add Click", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Items")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarMedium() {
    val contextForToast = LocalContext.current.applicationContext
    MediumTopAppBar(// Título de la barra superior
        title = {

            Text(text = "TopAppBar")
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Nav Icon Click", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Add Click", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Items")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorito")
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarLarge() {
    val contextForToast = LocalContext.current.applicationContext
    LargeTopAppBar(
        // Título de la barra superior
        title = {

            Text(text = "TopAppBar")
        },
        navigationIcon = {
            IconButton(onClick = {
                //Toast.makeText(contextForToast, "Nav Icon Click", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Add Click", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Items")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorito")
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}
