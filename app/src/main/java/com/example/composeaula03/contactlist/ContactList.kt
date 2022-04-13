package com.example.composeaula03.contactlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun ContactList(navController: NavController) {
    var name by remember { mutableStateOf("")}
    var age by remember { mutableStateOf(0)}
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Lista de Contatos")
        OutlinedTextField(value = name, onValueChange = {
            name = it
        })
        OutlinedTextField(value = "$age", onValueChange = {
            age = if(it.length > 0) it.toInt() else 0
        })
        Button(onClick = {
            navController.navigate("addeditcontact/$name/$age"){
                popUpTo("contactlist")
            }
        }) {
            Text(text = "Adicionar Contato")
        }
    }
}

@Preview
@Composable
fun ContactListPreview() {
    //ContactList()
}