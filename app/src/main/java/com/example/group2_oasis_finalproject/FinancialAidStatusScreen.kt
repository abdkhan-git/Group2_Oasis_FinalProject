package com.example.group2_oasis_finalproject

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun financialAidStatusScreen(navController: NavController) {
    var viewModel = viewModel {FinancialAidStatusScreenViewModel()}
    var showcostofattendance by remember { mutableStateOf(false) }
    Column {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "The following information is based on your status as a NYS Resident w/Parent FT student receiving financial aid for the Fall-Spring Semesters.", style = MaterialTheme.typography.bodySmall, fontSize = 12.sp, color = Color.Gray,)
            Text(text = "This is a summary of your financial aid information for the specified aid year. To obtain greater detail about any of the following summary statements, click the corresponding link.", style = MaterialTheme.typography.bodySmall, fontSize = 12.sp, color = Color.Gray,)
        }
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Row {
                Text("Your estimated ")
                Text(text = "cost of attendance ", color = Color.Blue, modifier = Modifier.clickable { showcostofattendance = true })
                Text("is $15,612.00.")
            }
            Text(text = "You have been awarded financial aid which totals $14,570.00.")
            Text(text = "Based on your academic transcript, the status of your academic progress is Reviewed Making Good Progress as of Fall 2024.")
            Text(text = "You have financial aid credits which appear within your account summary.")
            if (showcostofattendance) {
                AlertDialog(
                    onDismissRequest = { showcostofattendance = false },
                    title = { Text("cost of attendance") },
                    text = {
                        Column {
                        Text("Books,CourseSupplies,Equipment \t\n" + "\n" + "\$1,300.00\n")
                        HorizontalDivider()
                        Text("Fees \t\n" + "\n" + "\$1,556.00\n")
                        HorizontalDivider()
                        Text("Personal Expenses \t\n" + "\n" + "\$1,300.00\n")
                        HorizontalDivider()
                        Text("Housing and Food \t\n" + "\n" + "\$2,536.00\n" )
                        HorizontalDivider()
                        Text("Transportation \t\n" + "\n" + "\$1,850.00\n" )
                        HorizontalDivider()
                        Text("Tuition \t\n" + "\n" + "\$7,070.00\n" )
                        HorizontalDivider()
                        Text("Total: \t\n" + "\n" + "\$15,612.00")} },
                    confirmButton = { Button(onClick = { showcostofattendance = false }) { Text("OK") } }
                )
            }
        }
    }
}
