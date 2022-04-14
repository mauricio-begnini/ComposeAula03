package com.example.composeaula03.addeditcontact

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddEditContactScren(
    navController: NavController,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("contactlist"){
                    popUpTo("contactlist"){
                        inclusive = true
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Confirm")
            }
        }
    ) {
        AddEditContactForm()
    }
}

@Composable
fun AddEditContactForm() {
    var name by remember { mutableStateOf("")}
    var number by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = {
                    Text(text = "Name")
            },
            value = name,
            onValueChange = { newName->
                name = newName
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = {
                Text(text = "Number")
            },
            value = number,
            onValueChange = { newNumber->
                number = newNumber
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(text = "Address")
            },
            value = address,
            onValueChange = { newAddress->
                address = newAddress
            }
        )

    }
}

@Preview
@Composable
fun AddEditContactFormPreview() {
    AddEditContactForm()
}
