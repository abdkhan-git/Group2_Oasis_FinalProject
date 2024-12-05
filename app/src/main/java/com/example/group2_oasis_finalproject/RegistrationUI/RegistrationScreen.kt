package com.example.group2_oasis_finalproject.RegistrationUI

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
import com.example.group2_oasis_finalproject.R

@Composable
fun registrationscreen(navController: NavController) {
    LazyColumn {
        item {
            Text(
                text = "Financial Aid Eligibility (Matriculated Students): If you are a financial aid recipient, please be aware that only the courses that count toward your current academic program can be included in determining your eligibility for federal and/or state financial aid.\n" +
                        "Once you have registered for classes, please use the DegreeWorks degree audit software to determine if the courses selected do in fact count towards your academic program and that you are on track to graduate. If your schedule includes courses that do not count towards your program those courses will not be eligible for federal and/or state aid. For more information see the DegreeWorks and Financial Aid Applicable Credits page on our website. If you have questions please see your academic advisor.\n" +
                        "\n" +
                        "Online Payment Note: Payments via Master Card, VISA, Discover or Amex can be made by clicking here Credit Card Payment or on the Complete Registration & Pay Your Bill link that can be found at the bottom of this page. Please be aware that the OASIS credit card payment site is encrypted and PCI compliant and that Farmingdale State does not store credit card numbers in their student database.\n" +
                        "\n" +
                        "Classroom Schedule Info: To view your currrent class schedule click on either the Student Detail Schedule or the Concise Student Schedule links below.\n" +
                        "Please note that classroom locations may change during the first two weeks of the semester, so review your schedule often.\n" +
                        "\n" +
                        "For step by step registration guide, click Registration Instructions.\n" +
                        "Inclusive Access Fee: FSC is implementing a new fee exclusively tied to specific courses that will provide for course materials for students at a significantly reduced cost. This new inclusive access textbook program, also known as First Day Inclusive Access, will deliver digital course materials via Brightspace so they are available on the first day of class. Students registered for courses that have adopted First Day Inclusive Access will automatically be assessed an Inclusive Access Fee. Any student enrolled in a course that has adopted First Day Inclusive Access may opt-out of the fee. Opting out of the fee, and the automatic delivery of digital course materials IS NOT recommended. If you opt-out, you are responsible for purchasing textbooks and course materials on your own. Students wishing to opt-out may do so via Brightspace. Opt-out requests must be received prior to the add/drop date. Students with questions or those students having trouble accessing course materials, should contact Bookstore Customer Care at bookstorecustomercare@bncollege.com for assistance.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        //Select a Term
        item {
            ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .fillMaxSize(), onClick = { navController.navigate("SelectATermScreen") })
            {
                Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(text = "Select a Term", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                        Text(text = "Select from a list of Web-avaliable terms", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                    }
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
                }
            }}
        // Check your registration status
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Check Your Registration Status", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Click here to determine if you are eligible to Register. You must resolve any HOLDS or other problems before proceeding", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }}
        // look-up classes to add
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Look-up Classes to Add", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Search for available classes...", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }}
        // add/drop classes
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Add/Drop Classes", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Register for classes and/or change your schedule.", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }} // Student Detail Schedule
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Student Detail Schedule", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Your class schedule in detail.", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }}
        //concise student schedule
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Concise Student Schedule", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Printer friendly student schedule.", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }}
        //Order Textbooks Online
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Order Textbooks Online", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "View the textbooks assigned to the courses you are registered in, at the Farmingdale State bookstore (Barnes and Noble). Purchase option available.", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }}
        //	Complete Registration & Pay Your Bill
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Complete Registration & Pay Your Bill", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Display your registration charges for the semester. Pay online via MasterCard or VISA.", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }}
        // check reg status
        item { ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,), modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxSize(), onClick = { navController.navigate("RegistrationScreen") })
        {
            Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(text = "Check your registration status", lineHeight = TextUnit(2f, TextUnitType.Em), fontWeight = FontWeight.Bold)
                    Text(text = "Click here to determine if you are eligible to Register. You must reolve any HOLDS or other problems before proceeding", lineHeight = TextUnit(1.5f, TextUnitType.Em))
                }
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.fsc), contentDescription = "", Modifier.align(Alignment.CenterVertically))
            }
        }
        }
    }
}