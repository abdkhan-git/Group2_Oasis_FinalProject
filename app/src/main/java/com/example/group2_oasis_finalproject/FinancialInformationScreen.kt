package com.example.group2_oasis_finalproject

import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun financialinformationscreen(navController: NavController) {
    val Context = LocalContext.current
    LazyColumn {
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Financial Aid Status", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "View overall status, holds, academic progress, cost of attendance, financial aid awards, and messages.", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(
                    Alignment.CenterVertically))
            }
        }
        }
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(),
            onClick = {
//                val intent = Intent(Intent.ACTION_SEND).apply { putExtra(Intent.EXTRA_EMAIL, "FAOffice@Farmingdale.edu") }
//                Context.startActivity(intent)
            })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "E-Mail Farmingdale State Financial Aid Office", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Send your questions to the FinAid Office staff", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(
                    Alignment.CenterVertically))
            }
        }
        }
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier.fillMaxWidth().padding(10.dp).fillMaxSize(),
            onClick = {
                val webpage: Uri = Uri.parse("https://www.farmingdale.edu/student-financial-services/financial-aid/tools-resources.shtml")
                val intent = Intent(Intent.ACTION_VIEW, webpage)
                Context.startActivity(intent) })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Financial Aid Tools and Resources", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Financial Aid Tools and Resources", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(
                    Alignment.CenterVertically))
            }
        }
        }}
}