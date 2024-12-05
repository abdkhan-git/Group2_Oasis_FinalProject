package com.example.group2_oasis_finalproject

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun SocialSecurityScreen(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Social Security Number Change Information",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Scrollable Content
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                // Transparent Image Placeholder
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fsclogo1c),
                        contentDescription = "Transparent Image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            item {
                Text(
                    text = "A request to change your social security number in the College's Administrative System must be made in person at the appropriate office.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            item {
                Text(
                    text = "If you are an employee (faculty, staff, or student), federal regulations require employers to validate that each employee's social security number and name on record exactly matches the social security number and name which appear on the individual's social security card to ensure proper tax reporting. Thus, in order to change either your social security number or your name in your personnel or payroll records, you must present your social security card which reflects your correct social security number to the Payroll Office in Whitman Hall.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            item {
                Text(
                    text = "If you are a student, and are not employed with the College, please bring your social security card to the Registrar's Office in Laffin Hall. If you have any questions or concerns, please call the Registrar's Office at (631) 420-2776.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            item {
                // Clickable Text for Link
                val linkText = buildAnnotatedString {
                    append("For additional information on how to apply for, replace, correct, or change your name on your Social Security Card, ")
                    pushStringAnnotation(tag = "URL", annotation = "https://www.ssa.gov/replace_sscard.html")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("click here")
                    }
                    pop()
                    append(". To return to this page, use your browser's Back button.")
                }

                ClickableText(
                    text = linkText,
                    style = MaterialTheme.typography.bodySmall,
                    onClick = { offset ->
                        linkText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                            .firstOrNull()?.let { annotation ->
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                                context.startActivity(intent)
                            }
                    },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Release: 5.2\n© 2024 Ellucian Company L.P. and its affiliates.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}
