package com.example.composeaula03.addeditcontact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeaula03.data.Contact

class AddEditContactViewModel : ViewModel() {

    private val _id : MutableLiveData<Int> = MutableLiveData(5)

    /*val id: LiveData<Int>
        get() = _id
    fun changeId(newId: Int){
        _id.value = newId
    }*/

    val name : MutableLiveData<String> = MutableLiveData("")
    val number : MutableLiveData<String> = MutableLiveData("")
    val address : MutableLiveData<String> = MutableLiveData("")

    fun insertContact(
        onInsertContact: (Contact) -> Unit
    ){
        val newContact = Contact(
            _id.value ?: return,
            name.value ?: return,
            number.value?: return,
            address.value?: return
        )
        onInsertContact(newContact)
        var tempId: Int = _id.value ?: return
        tempId++
        _id.value = tempId

        name.value = ""
        number.value = ""
        address.value = ""
    }

    fun updateContact(
        id: Int,
        onUpdateContact: (Contact) -> Unit
    ){
        val contact = Contact(
            id,
            name.value ?: return,
            number.value ?: return,
            address.value ?: return,
        )
        onUpdateContact(contact)
    }
}