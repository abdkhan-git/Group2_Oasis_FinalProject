package com.example.group2_oasis_finalproject

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.ClickableText

@Composable
fun NameChangeScreen() {
    // Get the context to handle navigation
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Make the column scrollable
    ) {
        // Title
        Text(
            text = "Name Change Information",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Image
        Image(
            painter = painterResource(id = R.drawable.fsclogorgb),
            contentDescription = "Transparent Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Information Text
        Text(
            text = "A request to change your name in the College's Administrative System must be made in person at the appropriate office.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = """
                If you are an employee (faculty, staff, or student), federal regulations require employers to validate that the employee's name on record exactly matches the name which appears on the individual's social security card to ensure proper tax reporting. Thus, in order to reflect your name change on your personnel and payroll records, you must present your social security card which reflects your new name to the Payroll Office in Whitman Hall.
                
                If you are a student and are not employed with the College, please bring your social security card to the Registrar's Office in Laffin Hall.
                
                If you have not requested a change of name with the Social Security Administration, please apply for a new social security card with the nearest Social Security Administration Office. (Note: You will need to bring an original legal document reflecting your new name to support your request for the name change. Examples of accepted legal documents include a birth certificate, marriage license, divorce decree, etc.) Once you receive your new Social Security card, please bring it to the appropriate office.
                
                If you have any questions or concerns, please call the Registrar's Office at (631) 420-2776.
            """.trimIndent(),
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

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

        Spacer(modifier = Modifier.height(16.dp))

        // Footer
        Text(
            text = "Release: 5.2\n© 2024 Ellucian Company L.P. and its affiliates.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
