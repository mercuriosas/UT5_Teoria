package com.example.ut5_teoria

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ut5_teoria.ui.theme.UT5_TeoriaTheme
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT5_TeoriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CustomScaffold()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UT5_TeoriaTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
// Función Composable que crea un Scaffold personalizado
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold() {
    val corutina = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val contextForToast = LocalContext.current.applicationContext
    val MydrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectecItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val itemDrawer = listOf<ModalDrawer>(
        ModalDrawer(
            title = "All",
            selectedIcon = Icons.Filled.Home,
            unslectecIcon = Icons.Outlined.Home,
        ),
        ModalDrawer(
            title = "Urgent",
            selectedIcon = Icons.Filled.Info,
            unslectecIcon = Icons.Outlined.Info,
        ),
        ModalDrawer(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unslectecIcon = Icons.Outlined.Settings,
        )
    )
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Image(painter = painterResource(id = R.drawable.dragonball), contentDescription ="dragon" )
                Spacer(modifier = Modifier.height(16.dp))
                itemDrawer.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.title) },
                        selected = index == selectecItemIndex,
                        onClick = {
                            selectecItemIndex = index
                            corutina.launch {
                                MydrawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectecItemIndex) {
                                    item.selectedIcon
                                } else {
                                    item.unslectecIcon
                                }, contentDescription = item.title
                            )
                        },
                        badge = {
                            item.badgedCount?.let {
                                Text(text = item.badgedCount.toString())
                            }
                        }
                    )
                }
            }
        }, drawerState = MydrawerState
    ) {
        Scaffold(
            // Barra superior
            topBar = {
                //MyTopAppBarSmall()
                //MyTopAppBarCenter()
                //MyTopAppBarMedium()
                //MyTopAppBarLarge()
                //MyTopAppBar()
                CenterAlignedTopAppBar(// Título de la barra superior
                    title = {
                        Row(
                            Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
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
                            corutina.launch {
                                MydrawerState.open()
                            }
                            //Toast.makeText(contextForToast, "Nav Icon Click", Toast.LENGTH_SHORT).show()
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            Toast.makeText(contextForToast, "Add Click", Toast.LENGTH_SHORT)
                                .show()
                        }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Items"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )

            },

            // Barra inferior
            bottomBar = { MyBottomAppBar() },

            // Botón flotante personalizado
            floatingActionButton = {
                MyFAB()
                //MySmallFAB()
                //MyLargeFAB()
                //MyExtendedFAB()
            },
            floatingActionButtonPosition = FabPosition.Center,

            //Snackbar
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },

            // Contenido principal
            content = { paddingValues ->

                Column(Modifier.padding(paddingValues)) {
                    Greeting(name = "Hola")
                    Button(onClick = {
                        corutina.launch {
                            snackbarHostState.showSnackbar(
                                "Has pulado la App"
                            )
                        }
                    }) {
                        Text(text = "Show SnackBar")
                    }
                }
            }
        )
    }
}
/*

    ModalNavigationDrawer(
        drawerContent = {
            itemDrawer.forEachIndexed { index, item ->
                NavigationDrawerItem(
                    label = { Text(text = item.title) },
                    selected = index == selectecItemIndex,
                    onClick = {
                        selectecItemIndex = index
                        corutina.launch {
                            MydrawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectecItemIndex) {
                                item.selectedIcon
                            } else {
                                item.unslectecIcon
                            }, contentDescription = item.title
                        )
                    },
                    badge = {
                        item.badgedCount?.let {
                            Text(text = item.badgedCount.toString())
                        }
                    }
                )
            }
        },
        drawerState = MydrawerState
    ) {

    }
*/

