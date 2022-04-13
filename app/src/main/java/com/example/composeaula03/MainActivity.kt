package com.example.composeaula03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeaula03.addeditcontact.AddEditContact
import com.example.composeaula03.contactlist.ContactList
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
                ContactList(navController)
            }
            composable(
                route = "addeditcontact/{name}/{age}",
                arguments = listOf(
                    navArgument("name"){
                        type = NavType.StringType
                    },
                    navArgument("age"){
                        type = NavType.IntType
                    }
                )
            ){ navBackStackEntry ->
                val name = navBackStackEntry.arguments?.getString("name")
                val age = navBackStackEntry.arguments?.getInt("age")
                AddEditContact(navController, name, age)
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