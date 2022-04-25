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

    private val _filterBy: MutableLiveData<String> = MutableLiveData("")

    val filterBy: LiveData<String>
        get() = _filterBy

    val contactList: LiveData<List<Contact>>
        get() {
            return if(_filterBy.value == "")
                _contactList
            else{
                val list: List<Contact> = _contactList.value?.filter { contact ->
                    contact.name.contains(_filterBy.value ?: "")
                } ?: listOf()
                MutableLiveData(list)
            }
        }

    fun updateFilter(newFilter: String) {
        _filterBy.value = newFilter
    }

    fun insertContact(contact: Contact){
        val list: MutableList<Contact> = _contactList.value?.toMutableList() ?: return
        list.add(contact)
        _contactList.value = list
    }

    fun updateContact(updatedContact: Contact){
        var pos = -1
        _contactList.value?.forEachIndexed { index, contact ->
            if(updatedContact.id == contact.id)
                pos = index
        }
        val list: MutableList<Contact> = _contactList.value?.toMutableList() ?: return
        list.removeAt(pos)
        list.add(pos, updatedContact)
        _contactList.value = list
    }

    fun removeContact(id: Int){
        var pos = -1
        _contactList.value?.forEachIndexed { index, contact ->
            if(id == contact.id)
                pos = index
        }
        val list: MutableList<Contact> = _contactList.value?.toMutableList() ?: return
        list.removeAt(pos)
        _contactList.value = list
    }

    fun getContact(id: Int): Contact {
        _contactList.value?.forEach{ contact ->
            if(id == contact.id)
                return contact
        }
        return Contact(
            -1,
            "",
            "",
            ""
        )
    }

}