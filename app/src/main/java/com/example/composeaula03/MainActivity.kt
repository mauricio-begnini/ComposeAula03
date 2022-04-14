package com.example.composeaula03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeaula03.addeditcontact.AddEditContactScren
import com.example.composeaula03.contactlist.ContactListScreen
import com.example.composeaula03.ui.theme.ComposeAula03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAula03Theme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(){
        NavHost(navController = navController, startDestination = "contactlist"){
            composable("contactlist"){
                ContactListScreen(navController)
            }
            composable(route = "addeditcontact"){
                AddEditContactScren(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ComposeAula03Theme {

    }
}