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
fun personalinformationscreen(navController: NavController) {
    LazyColumn {
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Change Pin", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Change Your Personal Identification Number (PIN)", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(
                    Alignment.CenterVertically))
            }
        }
        }
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "View E-mail Address", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "View What Email Adress We Have On File For You", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(
                    Alignment.CenterVertically))
            }
        }
        }
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Name Change Information", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Information On Changing Your Name In Our Records", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(
                    Alignment.CenterVertically))
            }
        }
        }}
}