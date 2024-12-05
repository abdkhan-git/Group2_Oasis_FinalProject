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
import androidx.navigation.NavController


@Composable
fun UpdateEmergencyContactsScreen(navController: NavController) {
    // Contact list with a state to update dynamically
    val contactList = remember { mutableStateListOf<EmergencyContact>() }
    val showAddContactDialog = remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header Section
        item {
            Image(
                painter = painterResource(id = R.drawable.fsclogorgb), // Farmingdale logo
                contentDescription = "Transparent Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Update Emergency Contacts - Select Contact",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Your current emergency contact information is listed below. To update a contact, click the name of the contact you wish to update. To add a new contact, click New Contact.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Emergency Contacts",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Emergency Contacts
        items(contactList.size) { index ->
            val contact = contactList[index]
            ContactRow(contact = contact, onClick = { /* Handle update action */ })
        }

        // Buttons
        item {
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = { showAddContactDialog.value = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Add New Contact")
            }

            // Button to navigate to ViewEmergencyContactsScreen
            OutlinedButton(
                onClick = { navController.navigate("ViewEmergencyContactsScreen") },  // Navigate to view_contacts screen
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "View Emergency Contacts")
            }
        }
    }

    // Add Contact Dialog
    if (showAddContactDialog.value) {
        AddContactDialog(
            onDismiss = { showAddContactDialog.value = false },
            onAddContact = { newContact ->
                contactList.add(newContact)
                showAddContactDialog.value = false
            }
        )
    }
}



@Composable
fun AddContactDialog(onDismiss: () -> Unit, onAddContact: (EmergencyContact) -> Unit) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var relationship by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Add New Contact") },
        text = {
            Column {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )
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
                if (name.isNotBlank() && address.isNotBlank() && phone.isNotBlank() && relationship.isNotBlank()) {
                    onAddContact(EmergencyContact(name, address, phone, relationship))
                }
            }) {
                Text(text = "Add")
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
