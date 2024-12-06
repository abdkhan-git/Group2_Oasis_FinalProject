package com.example.group2_oasis_finalproject

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


class EmergencyContactViewModel : ViewModel() {
    // Holds the list of contacts
    val contactList = mutableStateListOf<EmergencyContact>()

    // Adds a new contact to the list
    fun addContact(contact: EmergencyContact) {
        contactList.add(contact)
    }

    // Updates an existing contact in the list
    fun updateContact(updatedContact: EmergencyContact) {
        val index = contactList.indexOfFirst { it.name == updatedContact.name }
        if (index != -1) {
            contactList[index] = updatedContact
        }
    }

    // Deletes a contact from the list (optional)
    fun deleteContact(contact: EmergencyContact) {
        contactList.remove(contact)
    }
}