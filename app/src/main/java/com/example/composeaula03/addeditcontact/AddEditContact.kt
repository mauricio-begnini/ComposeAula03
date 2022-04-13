package com.example.composeaula03.addeditcontact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun AddEditContact(
    navController: NavController,
    name: String?,
    age: Int?
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Adicionar ou Editar Contato")
        Text(text = "name = $name, age = $age")
        Button(onClick = {
            navController.navigate("contactlist"){
                popUpTo("contactlist"){
                    inclusive = true
                }
            }
        }) {
            Text(text = "Lista Contatos")
        }
    }
}

@Preview
@Composable
fun AddEditContactPreview() {
    //AddEditContact()
}
