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
fun registrationscreen(navController: NavController) {
    LazyColumn {
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
            {
                Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(text = "Select a Term", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                        Text(text = "Select from a list of Web-avaliable terms", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    }
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
                }
            }}
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Check Your Registration Status", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Click here to determine if you are eligible to Register. You must resolve any HOLDS or other problems before proceeding", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }}
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Check your registration status", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Click here to determine if you are eligible to Register. You must reolve any HOLDS or other problems before proceeding", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }}}
}