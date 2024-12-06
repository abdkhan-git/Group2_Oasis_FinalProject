package com.example.group2_oasis_finalproject

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.group2_oasis_finalproject.ui.theme.FarmingdaleGreen


@Composable
fun EmergencyAlertScreen(context: Context) {

    var showDisclaimer by remember { mutableStateOf(false) } // State to track disclaimer visibility

    var showDataPrivacy by remember { mutableStateOf(false) } // State to track disclaimer visibility

    val annotatedText1 = buildAnnotatedString {
        append("Farmingdale State - Emergency Management and Disaster Preparedness Plan, March 2003")
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            ),
            start = 0,
            end = length
        )
        addStringAnnotation(
            tag = "URL",
            annotation = "https://oasis.farmingdale.edu/studocs/emergencyplan_march2003.pdf",
            start = 0,
            end = length
        )
    }

    val annotatedText2 = buildAnnotatedString {
        append("Farmingdale State - Emergency Response Critical Path Communications")
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            ),
            start = 0,
            end = length
        )
        addStringAnnotation(
            tag = "URL",
            annotation = "https://oasis.farmingdale.edu/studocs/emergencycommunications030408d.pdf",
            start = 0,
            end = length
        )
    }

    // Scrollable column to avoid overlapping
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())  // Make the entire column scrollable
            .padding(16.dp)
    ) {
        // Image
        Image(
            painter = painterResource(id = R.drawable.fsclogorgb),
            contentDescription = "Transparent Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Title
        Text(
            text = "Emergency Alert Notification",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Description
        Text(
            text = "State University of New York Emergency Alert System",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ClickableText(
            text = annotatedText1,
            onClick = { offset ->
                annotatedText1.getStringAnnotations("URL", offset, offset).firstOrNull()?.let {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.item))
                    context.startActivity(intent)
                }
            },
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ClickableText(
            text = annotatedText2,
            onClick = { offset ->
                annotatedText2.getStringAnnotations("URL", offset, offset).firstOrNull()?.let {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.item))
                    context.startActivity(intent)
                }
            },
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Description of the alert system
        Text(
            text = "Our campus has implemented an Emergency Alert System based on the SUNY NY-ALERT service created and" +
                    " maintained by the New York State Emergency Management Office. This system will be used to provide information" +
                    " to our entire campus community in response to any event or situation on the campus which poses a serious safety concern.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        // Options Text
        Text(
            text = "I have reviewed the description of the campus SUNY NY-ALERT service and have decided on the following course of action:",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Radio Group
        RadioGroup(
            options = listOf(
                "I would like to register for this service now and receive any alerts sent to the campus community.",
                "I will participate in this service but do not have time right now. I understand that I will be asked again in 14 days.",
                "I am not interested in participating in this service. I understand that safety alerts from this system would not be sent to me."
            ),
            onOptionSelected = { /* Handle selection */ }
        )

        Spacer(modifier = Modifier.height(20.dp))  // Give more space between sections

        // Continue, Disclaimer, and Data Privacy Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* Handle Continue */ },
                colors = ButtonDefaults.buttonColors(containerColor = FarmingdaleGreen)
            ) {
                Text("Continue", color = Color.White)
            }

            // Disclaimer Button: Toggles visibility of disclaimer message
            OutlinedButton(onClick = { showDisclaimer = !showDisclaimer }) {
                Text("Disclaimer")
            }

            OutlinedButton(onClick = { showDataPrivacy = ! showDataPrivacy }) {
                Text("Data Privacy")
            }
        }

        // Display disclaimer if showDisclaimer is true
        if (showDisclaimer) {
            Spacer(modifier = Modifier.height(16.dp)) // Add some space before the disclaimer text
            Text(
                text = "While in the event of an emergency, the University will make every effort to reach all students and " +
                        "staff through the contact information they have submitted to the SUNY NY-ALERT system, the University " +
                        "acknowledges that technical limitations such as overtaxed communications systems, transmission errors, and " +
                        "cellular telephone roaming and out of range areas, as well as human delays in issuing emergency messages may limit " +
                        "the effectiveness of the system and delay or prevent the issuance or receipt of messages to all or certain users.\n\n" +
                        "SUNY will make every effort to inform all users of an emergency in a timely and appropriate manner, but cannot guarantee" +
                        " performance of the system and disclaims liability for messages delayed or not received due to technological limitations or" +
                        " human error.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        // Display data privacy
        if (showDataPrivacy) {
            Spacer(modifier = Modifier.height(16.dp)) // Add some space before the disclaimer text
            Text(
                text = "\n" +
                        "Data Privacy Statement\n" +
                        "\n" +
                        "The Emergency Alert System is designed to alert you in cases where your personal safety may be at risk. For this reason it is critical that the SUNY NY-ALERT system have email, text messaging and phone numbers you use on a regular basis. Please be assured that the data you provide will be used for no other purpose. It will be used to maintain the Emergency Contact information for SUNY NY-ALERT but will not be placed within Banner and will not be used to contact you for any other reason.\n" +
                        "\n" +
                        "To provide for an easier SUNY NY-ALERT registration process, this enrollment application will optionally copy data from the Banner Student system. This is only offered during the initial data entry process as a convenience and the data will NOT be used to update Banner. If you wish to correct contact information within Banner, use the Personal Information Menu within Banner Self-Service to do this.\n" +
                        "\n" +
                        "The data you provide will be sent to the State Emergency Management Office by SUNY System Administration. It will be sent to no other third parties, public or private. You will be able to alter your data at any time on the Banner Self-Service Personal Information menu including the option to remove yourself from the system. Data is transmitted weekly so registration and data changes can take up to seven days to alter the alert system.\n" +
                        "\n" +
                        "We consider this data critical and strongly encourage your participation. You will be able to enroll at any time using the Personal Information Menu in Banner Self-Service. You will be prompted at the beginning of each semester to confirm your decision regarding participation and offered an opportunity to update your personal contact data.\n" +
                        "\n" +
                        "By submitting contact information you are providing your consent for disclosure of this information to both SUNY System Administration and to the State Emergency Management Office.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }


        Spacer(modifier = Modifier.height(20.dp))

        // Footer
        Text(
            text = "Release: 8.7.4.S\n© 2024 Ellucian Company L.P. and its affiliates.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun RadioGroup(options: List<String>, onOptionSelected: (String) -> Unit) {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Column {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onOptionSelected(option).also { selectedOption = option } }
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { onOptionSelected(option).also { selectedOption = option } }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }

}

