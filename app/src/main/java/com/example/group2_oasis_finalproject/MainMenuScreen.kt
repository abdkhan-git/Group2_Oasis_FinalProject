package com.example.group2_oasis_finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun mainmenuscreen(navController: NavController) {
    
    LazyColumn {
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize() ,onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Registration Screen",lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Check your registration status", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    Text(text = "Add or Drop Classes", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    Text(text = "Display your class schedule", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            } }}
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize() ,onClick = { navController.navigate("StudentRecordsScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Student Records",lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Order offical transcripts online", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    Text(text = "Display your grades and transcript", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    Text(text = "View your holds (restrictions)", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }}}
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize() ,onClick = { navController.navigate("PersonalInformationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Personal Information", lineHeight = TextUnit(2f, TextUnitType.Em),fontWeight = FontWeight.Bold)
                    Text(text = "View your personal information", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    Text(text = "change your OASIS login PIN and Security Question", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    Text(text = "Read information regarding changing your name.", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }}}
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(),onClick = { navController.navigate("FinancialInformationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Financial information", fontWeight = FontWeight.Bold, lineHeight = TextUnit(2f, TextUnitType.Em))
                    Text(text = "Review the status of your financial aid application", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    Text(text = "Check the status of your document requirements", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    Text(text = "Review your loans", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }}}
    }
}