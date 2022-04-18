package com.example.composeaula03.addeditcontact

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composeaula03.data.Contact

@Composable
fun AddEditContactScren(
    navController: NavController,
    addEditContactListViewModel: AddEditContactViewModel,
    onInsertContact: (Contact) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                addEditContactListViewModel.insertContact(onInsertContact)
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
        AddEditContactForm(addEditContactListViewModel)
    }
}

@Composable
fun AddEditContactForm(
    addEditContactListViewModel: AddEditContactViewModel
) {
    var name = addEditContactListViewModel.name.observeAsState()
    var number = addEditContactListViewModel.number.observeAsState()
    var address = addEditContactListViewModel.address.observeAsState()
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
            value = "${name.value}",
            onValueChange = { newName->
                addEditContactListViewModel.name.value = newName
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = {
                Text(text = "Number")
            },
            value = "${number.value}",
            onValueChange = { newNumber->
                addEditContactListViewModel.number.value = newNumber
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(text = "Address")
            },
            value = "${address.value}",
            onValueChange = { newAddress->
                addEditContactListViewModel.address.value = newAddress
            }
        )
    }
}

@Preview
@Composable
fun AddEditContactFormPreview() {
    val addEditContactViewModel: AddEditContactViewModel = viewModel()
    AddEditContactForm(addEditContactViewModel)
}
