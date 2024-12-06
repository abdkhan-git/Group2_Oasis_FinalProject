package com.example.group2_oasis_finalproject




import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController



@Composable
fun UpdateEmergencyContactsScreen(navController: NavController, viewModel: EmergencyContactViewModel = viewModel()) {
    val contactList = viewModel.contactList
    val showAddContactDialog = remember { mutableStateOf(false) }

    val updateContact: (EmergencyContact) -> Unit = { updatedContact ->
        viewModel.updateContact(updatedContact)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            // Image and Header Section
            Image(
                painter = painterResource(id = R.drawable.fsclogorgb),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Text(
                text = "Update Emergency Contacts - Select Contact",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(contactList.size) { index ->
            val contact = contactList[index]
            ContactRow(contact = contact, onClick = {
                // Pass the contact to the "AddContactDialog" screen (or update screen)
                navController.navigate("AddContactDialog?contactName=${contact.name}&contactAddress=${contact.address}&contactPhone=${contact.phone}&contactRelationship=${contact.relationship}")
            })
        }

        item {
            OutlinedButton(
                onClick = { showAddContactDialog.value = true },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text(text = "Add New Contact")
            }
        }

        // Add ViewEmergencyContacts button below the list
        item {
            OutlinedButton(
                onClick = { navController.navigate("ViewEmergencyContactsScreen") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text(text = "View Emergency Contacts")
            }
        }
    }

    if (showAddContactDialog.value) {
        AddContactDialog(
            onDismiss = { showAddContactDialog.value = false },
            onAddContact = { newContact ->
                viewModel.addContact(newContact) // Save contact via ViewModel
                showAddContactDialog.value = false
            }
        )
    }
}


@Composable
fun AddContactDialog(
    onDismiss: () -> Unit,
    onAddContact: (EmergencyContact) -> Unit,
    contact: EmergencyContact? = null // Receive the contact to be updated (if any)
) {
    var name by remember { mutableStateOf(contact?.name ?: "") }
    var address by remember { mutableStateOf(contact?.address ?: "") }
    var phone by remember { mutableStateOf(contact?.phone ?: "") }
    var relationship by remember { mutableStateOf(contact?.relationship ?: "") }
    var nameError by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = if (contact == null) "Add New Contact" else "Update Contact") },
        text = {
            Column {
                TextField(
                    value = name,
                    onValueChange = { newName ->
                        // Only update if the new name contains no numbers
                        if (newName.all { it.isLetter() || it.isWhitespace() }) {
                            name = newName
                            nameError = false
                        } else {
                            nameError = true
                        }
                    },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = nameError
                )
                if (nameError) {
                    Text(
                        text = "Name can only contain letters and spaces.",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = address,
                    onValueChange = { address = it },
                    label = { Text("Address") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = relationship,
                    onValueChange = { relationship = it },
                    label = { Text("Relationship") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                if (name.isNotBlank() && address.isNotBlank() && phone.isNotBlank() && relationship.isNotBlank() && !nameError) {
                    val updatedContact = EmergencyContact(name, address, phone, relationship)
                    if (contact == null) {
                        onAddContact(updatedContact)
                    } else {
                        onAddContact(updatedContact)  // This could be update logic if you already have a contact
                    }
                }
            }) {
                Text(text = if (contact == null) "Add" else "Update")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = "Cancel")
            }
        }
    )
}



@Composable
fun ContactRow(contact: EmergencyContact, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = contact.name,
            modifier = Modifier
                .weight(1f)
                .clickable { onClick() },
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = contact.address,
            modifier = Modifier.weight(2f),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = contact.phone,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = contact.relationship,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

data class EmergencyContact(
    val name: String,
    val address: String,
    val phone: String,
    val relationship: String
)
