package com.example.group2_oasis_finalproject

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Author: Jan Brix Batalla

@Composable
fun studentrecordsscreen(navController: NavController) {
    val context = LocalContext.current

    LazyColumn {
        item {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxSize(),
                onClick = { navController.navigate("ViewHoldScreen") }
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(
                            text = "View Holds",
                            lineHeight = TextUnit(2f, TextUnitType.Em),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "View any Holds (restrictions) placed on your account",
                            fontSize = 13.sp,
                            lineHeight = TextUnit(1.5f, TextUnitType.Em)
                        )
                    }
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.fsc),
                        contentDescription = null, Modifier.align(
                            Alignment.CenterVertically))
                }
            }
        }


        item { ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .fillMaxSize(),
            onClick = { navController.navigate("FinalGradeScreen") }
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                    Text(
                        text = "Final Grades",
                        lineHeight = TextUnit(2f, TextUnitType.Em),
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "View Your Final Grades",
                        fontSize = 13.sp,
                        lineHeight = TextUnit(1.5f, TextUnitType.Em)
                    )
                }
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.fsc),
                    contentDescription = null, Modifier.align(
                        Alignment.CenterVertically))
            }
        }
        }


        item {
            ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxSize(),
                onClick = { navController.navigate("AcademicTranscriptScreen") }
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(
                            text = "Academic Transcripts",
                            lineHeight = TextUnit(2f, TextUnitType.Em),
                            fontWeight = FontWeight.Bold)
                        Text(
                            text = "View your unofficial academic transcript.",
                            fontSize = 13.sp,
                            lineHeight = TextUnit(1.5f, TextUnitType.Em)
                        )
                    }
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.fsc),
                        contentDescription = null,
                        Modifier.align(Alignment.CenterVertically))
                }
            }
        }


        item {
            ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxSize(),
                onClick = { navController.navigate("AccountSummaryByTermScreen") }
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(
                            text = "Account Summary by Term",
                            lineHeight = TextUnit(2f, TextUnitType.Em),
                            fontWeight = FontWeight.Bold)
                        Text(
                            text = "View the charges you have incurred at the college - on a \nper semester basis",
                            fontSize = 13.sp,
                            lineHeight = TextUnit(1.5f, TextUnitType.Em)
                        )
                    }
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.fsc),
                        contentDescription = null,
                        Modifier.align(Alignment.CenterVertically))
                }
            }
        }


        item {
            ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxSize(),
                onClick = { navController.navigate("AccountSummaryScreen") }
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(
                            text = "Account Summary",
                            lineHeight = TextUnit(2f, TextUnitType.Em),
                            fontWeight = FontWeight.Bold)
                        Text(
                            text = "View a summary of the charges you have incurred at \nthe college",
                            fontSize = 13.sp,
                            lineHeight = TextUnit(1.5f, TextUnitType.Em)
                        )
                    }
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.fsc),
                        contentDescription = null,
                        Modifier.align(Alignment.CenterVertically))
                }
            }
        }


        item {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxSize(),
                onClick = { navController.navigate("TaxNotificationScreen") }
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(
                            text = "Tax Notification",
                            lineHeight = TextUnit(2f, TextUnitType.Em),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "View a representation of Tuition Statement form 1098-T",
                            fontSize = 13.sp,
                            lineHeight = TextUnit(1.5f, TextUnitType.Em)
                        )
                    }
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.fsc),
                        contentDescription = null,
                        Modifier.align(Alignment.CenterVertically))
                }
            }
        }


        item {
            ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxSize(),
                onClick = { navController.navigate("ViewStudentInformationScreen") }
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(
                            text = "View Student Information",
                            lineHeight = TextUnit(2f, TextUnitType.Em),
                            fontWeight = FontWeight.Bold)
                        Text(
                            text = "View some basic information about your student record, \nfind your Ram ID here",
                            fontSize = 13.sp,
                            lineHeight = TextUnit(1.5f, TextUnitType.Em)
                        )
                    }
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.fsc),
                        contentDescription = null,
                        Modifier.align(Alignment.CenterVertically))
                }
            }
        }


        item {
            ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant,),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxSize(),
                onClick = { navController.navigate("OrderOfficialTranscriptScreen") }
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column(Modifier.padding(top = 10.dp, bottom = 20.dp)) {
                        Text(
                            text = "Order Official Transcript",
                            lineHeight = TextUnit(2f, TextUnitType.Em),
                            fontWeight = FontWeight.Bold)
                        Text(
                            text = "Use this facility to order electronic or paper copies of \nyour official college transcript.",
                            fontSize = 13.sp,
                            lineHeight = TextUnit(1.5f, TextUnitType.Em)
                        )
                    }
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.fsc),
                        contentDescription = null,
                        Modifier.align(Alignment.CenterVertically))
                }
            }
        }
    }
}


// todo - [x] View Hold
@Composable
fun ViewHoldScreen(navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "A HOLD is a flag on your record that may stop you from registering or receiving your grades.\n" +
                    "Any holds on your record will be displayed below.\n" +
                    "A hold will remain in effect until the current date is past the \"To Date\" of the hold.\n",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
//            modifier = Modifier.padding(bottom = 8.dp)
        )


        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "You currently don't have any holds.",
            style = MaterialTheme.typography.bodyLarge,
//            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// todo - [x] FinalGradeScreen
@Composable
fun FinalGradeScreen(navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Semester: Fall 2024",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = "GPA: 4.00",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
        }

        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Courses:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val courses = listOf(
                "BCS430: Senior Project",
                "BCS371: Mobile Application Development",
                "BCS450: AWS",
                "CSC325: Software Engineering"
            )

            courses.forEach { course ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = course,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "A",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// todo - [] AcademicTranscriptScreen
@Composable
fun AcademicTranscriptScreen(navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Academic Transcripts",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val courses = listOf(
                "BCS430: Senior Project",
                "BCS371: Mobile Application Development",
                "BCS450: AWS",
                "CSC325: Software Engineering"
            )

            courses.forEach { course ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = course,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "A",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            Divider()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "GPA: 4.00",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// todo - [x] AccountSummaryByTermScreen
@Composable
fun AccountSummaryByTermScreen(navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(5.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Summary",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 10.dp)
        )


        SummaryRow ( label = "Account Balance:", value = "$0.00")


        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Fall 2024",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        TableHeader()
        val charges: List<ChargeItem> = listOf(
            ChargeItem("ADMN", "Administrative Fee", "$40.00", "$40.00", "$0.00"),
            ChargeItem("ATHL", "Intercollegiate Athletic Fee", "$215.00", "$215.00", "$0.00"),
            ChargeItem("CFEE", "College Fee", "$25.00", "$25.00", "$0.00"),
            ChargeItem("HSVC", "Health Service Fee", "$172.00", "$172.00", "$0.00"),
            ChargeItem("I015", "IAF - BCS 130", "$47.46", "$47.46", "$0.00"),
            ChargeItem("LPAY", "Late Payment Fee", "$40.00", "$40.00", "$0.00"),
            ChargeItem("REC", "Recreation Fee", "$16.00", "$16.00", "$0.00"),
            ChargeItem("SAF", "Student Activity Fee", "$100.00", "$100.00", "$0.00"),
            ChargeItem("TECH", "Technology Fee", "$222.00", "$222.00", "$0.00"),
            ChargeItem("TPRT", "Transportation Fee", "$24.00", "$24.00", "$0.00"),
            ChargeItem("TRAN", "Transcript Fees", "$10.00", "$10.00", "$0.00"),
            ChargeItem("TUIC", "Tuition Charge", "$3,535.00", "$2,923.46", "$612.46"),
            ChargeItem("DUNS", "Unsubsidized DL Loan", "$0.00", "$0.00", "$0.00")
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(charges) { charge ->
                ChargeRow(charge = charge)
            }
        }


        Spacer(modifier = Modifier.height(16.dp))


        SummaryRow(label = "Term Charges:", value = "$4,440.46")
        SummaryRow(label = "Term Credits and Payments:", value = "$4,440.46")
        SummaryRow(label = "Term Balance:", value = "$0.00")
    }
}


@Composable
fun SummaryRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun TableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Detail Code",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Description",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(3f)
        )
        Text(
            text = "Charge",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Payment",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Balance",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
    }
}


data class ChargeItem (
    val detailCode: String,
    val description: String,
    val charge: String,
    val payment: String,
    val balance: String,
)


@Composable
fun ChargeRow(charge: ChargeItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = charge.detailCode,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = charge.description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(3f)
        )
        Text(
            text = charge.charge,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = charge.payment,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = charge.balance,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// todo - [x] AccountSummaryScreen
@Composable
fun AccountSummaryScreen(navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(5.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Summary",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 10.dp)
        )


        AccountSummaryRow ( label = "Account Balance:", value = "$0.00")


        Spacer(modifier = Modifier.height(16.dp))


        AccountSummaryTableHeader()
        val charges: List<AccountChargeItem> = listOf(
            AccountChargeItem("ADMN", "Administrative Fee", "$40.00", "$40.00", "$0.00"),
            AccountChargeItem("ATHL", "Intercollegiate Athletic Fee", "$215.00", "$215.00", "$0.00"),
            AccountChargeItem("CFEE", "College Fee", "$25.00", "$25.00", "$0.00"),
            AccountChargeItem("HSVC", "Health Service Fee", "$172.00", "$172.00", "$0.00"),
            AccountChargeItem("I015", "IAF - BCS 130", "$47.46", "$47.46", "$0.00"),
            AccountChargeItem("LPAY", "Late Payment Fee", "$40.00", "$40.00", "$0.00"),
            AccountChargeItem("REC", "Recreation Fee", "$16.00", "$16.00", "$0.00"),
            AccountChargeItem("SAF", "Student Activity Fee", "$100.00", "$100.00", "$0.00"),
            AccountChargeItem("TECH", "Technology Fee", "$222.00", "$222.00", "$0.00"),
            AccountChargeItem("TPRT", "Transportation Fee", "$24.00", "$24.00", "$0.00"),
            AccountChargeItem("TRAN", "Transcript Fees", "$10.00", "$10.00", "$0.00"),
            AccountChargeItem("TUIC", "Tuition Charge", "$3,535.00", "$2,923.46", "$612.46"),
            AccountChargeItem("DUNS", "Unsubsidized DL Loan", "$0.00", "$0.00", "$0.00")
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(charges) { charge ->
                AccountSummaryChargeRow(charge = charge)
            }
        }


        Spacer(modifier = Modifier.height(16.dp))


        SummaryRow(label = "Charges:", value = "$4,440.46")
        SummaryRow(label = "Credits and Payments:", value = "$4,440.46")
        SummaryRow(label = "Account Balance:", value = "$0.00")
    }
}


@Composable
fun AccountSummaryRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun AccountSummaryTableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Detail Code",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Description",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(3f)
        )
        Text(
            text = "Charge",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Payment",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Balance",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
    }
}


data class AccountChargeItem (
    val detailCode: String,
    val description: String,
    val charge: String,
    val payment: String,
    val balance: String,
)


@Composable
fun AccountSummaryChargeRow(charge: AccountChargeItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = charge.detailCode,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = charge.description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(3f)
        )
        Text(
            text = charge.charge,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = charge.payment,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = charge.balance,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(1f)
        )
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// todo - [x] TaxNotificationScreen
@Composable
fun TaxNotificationScreen(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var selectedYear by remember { mutableStateOf<String?>(null) }
    val taxYears = listOf("2024", "2025", "2026", "2027")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "This is the information which has been, or will be, reported to the IRS on Form 1098-T. " +
                    "If you believe that information is incorrect, please contact the Bursar's Office immediately. " +
                    "You can update address and/or taxpayer information on the Student Tax Information page.\n",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Select a year to view its tax information:",
            style = MaterialTheme.typography.bodyLarge,
        )

        // Taken from OrderOfficialTranscriptScreen to make the user's experience easier
        val annotatedText = buildAnnotatedString {
            append("To get your Form 1098-T, click ")
            pushStringAnnotation(
                tag = "URL",
                annotation = "https://oasis.farmingdale.edu/pls/prod/bwtktxys.p_get_tax_year"
            )
            withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                append("here.")
            }
            pop()
            append(" \n\nNOTE: Be sure to close all windows when you are done to protect your personal information.")
        }

        ClickableText(
            text = annotatedText,
            style = MaterialTheme.typography.bodyMedium,
            onClick = { offset ->
                annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                        context.startActivity(intent)
                    }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ){
            items(taxYears) { year ->
                TaxYearItem(
                    year = year,
                    isExpanded = selectedYear == year,
                    onClick = {
                        selectedYear = if (selectedYear == year) null else year
                    }
                )
                Divider()
            }
        }
    }
}

@Composable
fun TaxYearItem(
    year: String,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = year,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = if (isExpanded) "Collapse" else "Expand"
            )
        }

        // If you guys wanna learn about this animation this is the link
        // todo - https://developer.android.com/develop/ui/compose/animation/composables-modifiers#animatedvisibility
        AnimatedVisibility(visible = isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                when (year) {
                    "2024" -> {
                        Text(
                            text = "Detail of Payment Received for $year:",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text =  "• Unsubsidized DL Loan: \$4,440.46\n" +
                                    "• Refund: \$559.54\n" +
                                    "• Term Total: \$4,440.46\n" +
                                    "• Term All Total: \$4,440.46\n",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 14.sp
                        )
                        //////////////////////////////////////////////////////////////
                        Text(
                            text = "Detail of Charges Billed for $year:",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text =  "• Intercollegiate Athletic Fee: \$215.00\n" +
                                    "• College Fee: \$25.00\n" +
                                    "• Recreation Fee: \$10.00\n" +
                                    "• Student Activity Fee: \$100.00\n" +
                                    "• Technology Fee: \$222.00\n" +
                                    "• Transcript Fees: \$24.00\n" +
                                    "• Tuition Charge: \$3,904.46\n"+
                                    "• Term Total: \$4,440.46\n" +
                                    "• Term All Total: \$4,440.46\n",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 14.sp
                        )
                    }
                    "2025", "2026", "2027" -> {
                        Text(
                            text = "Tax Notifications are not available for the tax year requested at this time.",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    // Can add an else for other years but 4 years of available Tax Info would be enough
                }
            }
        }
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// todo - [x] ViewStudentInformationScreen
@Composable
fun ViewStudentInformationScreen(navController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Questions regarding the information shown below, such as Academic Standing, should be directed to your department chairperson.",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        Text(
            text = "Student Information effective from Fall 2024 to The End of Time",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        InfoItem(label = "Registered for Term", value = "Yes")
        InfoItem(label = "First Term Attended", value = "Fall 2024")
        InfoItem(label = "Last Term Attended", value = "Fall 2024")
        InfoItem(label = "Status", value = "Active student")
        InfoItem(label = "Site", value = "Main Campus")
        InfoItem(label = "Residence", value = "In-state Resident")
        InfoItem(label = "Citizenship", value = "Citizen")
        InfoItem(label = "Student Type", value = "Continuing")
        InfoItem(label = "Class", value = "First Semester Freshman")
        InfoItem(label = "Expected Graduation Date", value = "May 16, 2027")
        InfoItem(label = "Expected Graduation Term", value = "Spring 2027")
        InfoItem(label = "Expected Graduation Year", value = "Academic Year 2026-2027")


        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Curriculum Information",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        InfoItem(label = "Current Program", value = "Bachelor of Science")
        InfoItem(label = "Level", value = "Undergraduate")
        InfoItem(label = "Program", value = "BS-Computer Prog and Info Sys")
        InfoItem(label = "Admit Term", value = "Fall 2024")
        InfoItem(label = "Class", value = "Freshman")
        InfoItem(label = "Catalog Term", value = "Fall 2024")
        InfoItem(label = "College", value = "Business")
        InfoItem(label = "Campus", value = "Farmingdale")
        InfoItem(label = "Major and Department", value = "Computer Programming/Info Sys, Computer Systems")
    }
}


@Composable
fun InfoItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(2f)
        )
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// todo - [x] OrderOfficialTranscriptScreen
@Composable
fun OrderOfficialTranscriptScreen(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        val annotatedText = buildAnnotatedString {
            append("The college has partnered with Credentials Solutions, LLC to accept online transcript orders.\n" +
                    "You can order your official transcripts 24 hours a day, 7 days a week.\n" +
                    "Transcripts can be sent electronically or mailed in hard copy, depending on the receiving institution or destination.\n" +
                    "We are now attempting to open another browser window (popup) and will transmit your information to Credentials Solutions to begin the transcript order process.\n" +
                    "If the window does not launch in a few seconds, please tap ")

            pushStringAnnotation(
                tag = "URL",
                annotation = "https://www.parchment.com/tplus/sso/login"
            )

            withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                append("here")
            }

            pop()

            append(" \n\nNOTE: Be sure to close all windows when you are done to protect your personal information.")
        }

        ClickableText(
            text = annotatedText,
            style = MaterialTheme.typography.bodyMedium,
            onClick = { offset ->
                annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                        context.startActivity(intent)
                    }
            }
        )

        Text(
            text = "This is the Order Official Transcript screen.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
