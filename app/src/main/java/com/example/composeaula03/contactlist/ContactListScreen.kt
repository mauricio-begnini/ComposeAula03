package com.example.composeaula03.contactlist

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeaula03.data.Contact
import kotlin.math.exp

val dummyList = listOf<Contact>(
    Contact(
        0,
        "Mauricio Begnini",
        "(99) 9 9999-9999",
        "Av. Expedicionários, 2150 - Campo da Água Verde, Canoinhas"
    ) ,
    Contact(
        1,
        "Lucas Bueno",
        "(99) 9 9999-9999",
        "Av. Expedicionários, 2150 - Campo da Água Verde, Canoinhas"
    ) ,
    Contact(
        2,
        "Luciano Barreto",
        "(99) 9 9999-9999",
        "Av. Expedicionários, 2150 - Campo da Água Verde, Canoinhas"
    ) ,
    Contact(
        3,
        "Alexandre Abreu",
        "(99) 9 9999-9999",
        "Av. Expedicionários, 2150 - Campo da Água Verde, Canoinhas"
    ) ,
    Contact(
        4,
        "Denílson Barbosa",
        "(99) 9 9999-9999",
        "Av. Expedicionários, 2150 - Campo da Água Verde, Canoinhas"
    ) ,
)

@Composable
fun ContactListScreen(navController: NavController) {
    Scaffold(
        floatingActionButton =  {
            FloatingActionButton(onClick = {
                navController.navigate("addeditcontact")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
            }
        }
    ) {
        ContactList(contacts = dummyList)
    }
}

@Composable
fun ContactList(contacts: List<Contact>) {
    LazyColumn(){
        items(contacts){ contact ->
            ContactEntry(contact = contact)
        }
    }
}

@Composable
fun ContactEntry(contact: Contact) {
    var expanded by remember { mutableStateOf(false)}
    Card(
        modifier = Modifier
            .padding(2.dp)
            .clickable {
                expanded = !expanded
            }
            .animateContentSize(
                spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(6.dp)
                        .clip(CircleShape)
                        .size(60.dp)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${contact.name[0].uppercase()}",
                        style = MaterialTheme.typography.h3
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = contact.name,
                    style = MaterialTheme.typography.h6
                        .copy(fontWeight = FontWeight.Bold)
                )
            }
            if(expanded){
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = contact.number,
                    style = MaterialTheme.typography.subtitle2.copy(color = Color.LightGray)
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp, bottom = 6.dp, end = 6.dp),
                    text = contact.address,
                    style = MaterialTheme.typography.subtitle2.copy(color = Color.LightGray)
                )
            }
        }
    }
}

@Preview
@Composable
fun ContactListScreenPreview() {
    ContactListScreen(rememberNavController())
}

@Preview
@Composable
fun ContactListPreview() {
    ContactList(contacts = dummyList)
}

@Preview
@Composable
fun ContactEntryPreview() {
    ContactEntry(
        Contact(
            0,
            "Mauricio Begnini",
            "(99) 9 9999-9999",
            "Av. Expedicionários, 2150 - Campo da Água Verde, Canoinhas"
        )
    )
}