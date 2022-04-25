package com.example.composeaula03.addeditcontact

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
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
fun AddEditContactScreen(
    navController: NavController,
    addEditContactListViewModel: AddEditContactViewModel,
    onInsertContact: (Contact) -> Unit,
    onUpdateContact: (Contact) -> Unit,
    onRemoveContact: (Int) -> Unit,
    contact: Contact
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if(contact.id == -1)
                    addEditContactListViewModel.insertContact(onInsertContact)
                else
                    addEditContactListViewModel.updateContact(
                        contact.id,
                        onUpdateContact
                    )

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
        addEditContactListViewModel.name.value = contact.name
        addEditContactListViewModel.number.value = contact.number
        addEditContactListViewModel.address.value = contact.address

        AddEditContactForm(
            addEditContactListViewModel,
            contact.id,
            onRemoveContact,
        ){
            navController.navigate("contactlist"){
                popUpTo("contactlist"){
                    inclusive = true
                }
            }
        }

    }
}

@Composable
fun AddEditContactForm(
    addEditContactListViewModel: AddEditContactViewModel,
    id: Int,
    onRemoveContact: (Int) -> Unit,
    navigateBack: () -> Unit
) {
    var name = addEditContactListViewModel.name.observeAsState()
    var number = addEditContactListViewModel.number.observeAsState()
    var address = addEditContactListViewModel.address.observeAsState()
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
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
        if(id != -1)
            FloatingActionButton(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    onRemoveContact(id)
                    navigateBack()
                }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }
    }
}
/*
@Preview
@Composable
fun AddEditContactFormPreview() {
    val addEditContactViewModel: AddEditContactViewModel = viewModel()
    AddEditContactForm(addEditContactViewModel)
}
*/