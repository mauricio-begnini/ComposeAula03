package com.example.composeaula03.contactlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeaula03.data.Contact

class ContactListViewModel : ViewModel() {

    private val _contactList: MutableLiveData<List<Contact>> = MutableLiveData(
        listOf(
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
    )

    val contactList: LiveData<List<Contact>>
        get() = _contactList

    fun insertContact(contact: Contact){
        val list: MutableList<Contact> = _contactList.value?.toMutableList() ?: return
        list.add(contact)
        _contactList.value = list
    }

}