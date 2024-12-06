package com.example.group2_oasis_finalproject

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GraduationListScreen(term: String) {
    val graduates = if (term == "Fall 2024") {
        getFall2024Graduates()
    } else {
        getWinter2025Graduates()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "CANDIDATES FOR GRADUATION",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Term: $term",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Column headers
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "CURRICULUM",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1.5f)
            )
            Text(
                text = "STUDENT NAME",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "DEGREE",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(0.5f)
            )
        }

        Divider()

        LazyColumn {
            items(graduates) { graduate ->
                GraduateRow(graduate)
                Divider()
            }
        }
    }
}

@Composable
fun GraduateRow(graduate: Graduate) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = graduate.curriculum,
            modifier = Modifier.weight(1.5f)
        )
        Text(
            text = graduate.name,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = graduate.degree,
            modifier = Modifier.weight(0.5f)
        )
    }
}

data class Graduate(
    val curriculum: String,
    val name: String,
    val degree: String
)

fun getFall2024Graduates(): List<Graduate> {
    return listOf(
        Graduate("Computer Security Technology", "Abidin, Zain Ul", "BS"),
        Graduate("Manufacturing Engineering Tech", "Abir, Meharab Rahman", "BS"),
        Graduate("Sport Management", "Abreu, Saul", "BS"),
        Graduate("Business Analytics", "Acampora, Joseph C", "BS"),
        Graduate("Horticultural Tech Mgmt", "Accomando, Roberto G", "BTECH"),
        Graduate("Criminal Justice:Law Enf Tech", "Acevedo, Caitlyn Naomi", "BS"),
        Graduate("Civil Engineering Technology", "Acharya, Yagya M", "BS"),
        Graduate("Mechanical Engineering Tech", "Adames, Reidy", "BS"),
        Graduate("Business Management", "Adams, Sabrina Maryellen", "BS"),
        Graduate("Mechanical Engineering Tech", "Adebayo, Babatunde Victor", "BS"),
        Graduate("Business Management", "Agaliotis, Jason", "BS"),
        Graduate("Computer Science", "Ahmad, Auroba", "BS"),
        Graduate("Mechanical Engineering Tech", "Akhtar, Muhammad Mubeen", "BS"),
        Graduate("Business Management", "Akines, Itianna Nichole", "BS"),
        Graduate("Applied Psychology", "Akram, Farqaleet", "BS"),
    )
}

fun getWinter2025Graduates(): List<Graduate> {
    return listOf(
        Graduate("Liberal Arts & Sciences", "Ahmed, Zoha M", "AA"),
        Graduate("Science/Technology & Society", "Ahmed, Zoha M", "BS"),
        Graduate("Construction Mgmt Engr Tech", "Akanbong, Victor Ayirinya", "BS"),
        Graduate("Science/Technology & Society", "Allen, Johnnetta Latoya", "BS"),
        Graduate("Liberal Arts & Sciences", "Arias, Xenia", "AA"),
        Graduate("Science/Technology & Society", "Bedar, Maseeh", "BS"),
        Graduate("Business Management", "Bernard, Lauren Faith", "BS"),
        Graduate("Computer Programming/Info Sys", "Blake, Tedane", "BS"),
        Graduate("Computer Security Technology", "Bonner, Daniel M", "BS"),
        Graduate("Business Management", "Bozzo, Moriah L", "BS"),
        Graduate("Crim Justice-Law Enforcement", "Byrnes, Jesse", "AS"),
        Graduate("Computer Programming/Info Sys", "Cardenas, Karla Elizabeth", "BS"),
        Graduate("Construction Mgmt Engr Tech", "Cheilas, Demetrios C", "BS"),
        Graduate("Science/Technology & Society", "Coiro, Graziella", "BS"),
        Graduate("Business Management", "Cossio, Jason", "BS"),
        Graduate("Business Management", "Davis, Kyle", "BS"),
        Graduate("Business Management", "Di Norcia, Michael Victor", "BS"),
        Graduate("Science/Technology & Society", "Diamond, Megan Louise", "BS"),
        Graduate("Computer Programming/Info Sys", "Dinuzzo, Matthew A", "BS"),
        Graduate("Architectural Engineering Tech", "Dixson, Brendan James", "BS"),
        Graduate("Aeronautical Sci:Prof Pilot", "Engel, Adam C", "BS"),
        Graduate("Science/Technology & Society", "Fletcher, Christopher", "BS"),
        Graduate("Business Management", "Florscher, Aidan Scott", "BS"),
        Graduate("Bioscience", "Getfield, Alexandra", "BS"),
        Graduate("Liberal Arts & Sciences", "Hayes, Scott Patrick", "AA"),
        Graduate("Criminal Justice:Law Enf Tech", "Healy, Maisy", "BS"),
        Graduate("Business Management", "Helton, Jenna Belinda", "BS"),
        Graduate("Marketing", "Helton, Jenna Belinda", "CERT"),
        Graduate("Professional Communications", "Hurtado, Jamie Nicole", "BS"),
        Graduate("Business Management", "Ilyas, Emin", "BS"),
        Graduate("Crim Justice-Law Enforcement", "Jensen, James Leo", "AS"),
        Graduate("Mechanical Engineering Tech", "Keskes, Philipe", "BS"),
        Graduate("Business Management", "Khan, Fazil", "BS"),
        Graduate("Business Management", "King, Michael A", "BS"),
        Graduate("Liberal Arts & Sciences", "Leahy, Ryan E", "AA"),
        Graduate("Sport Management", "Liu, Jerry", "BS"),
        Graduate("Liberal Arts & Sciences", "Louis, Ciara Magdalena", "AA"),
        Graduate("Science/Technology & Society", "Mace, Julia Katherine", "BS"),
        Graduate("Business Management", "Nascimento, Giovanna", "BS"),
        Graduate("Business Management", "Occhipinti, Erica Lynn", "BS"),
        Graduate("Business Management", "Ostane, Noldyne", "BS"),
        Graduate("Business Management", "Pacheco, Emily R", "BS"),
        Graduate("Criminal Justice:Law Enf Tech", "Piarulli, Kaela G", "BS"),
        Graduate("Business Management", "Pititto, Angelina Marie", "BS"),
        Graduate("Science/Technology & Society", "Ramdas, Jonah E", "BS"),
        Graduate("Business Management", "Reyes Cardona, Claudia Raquel", "BS"),
        Graduate("Criminal Justice:Law Enf Tech", "Rodriguez, Jennifer May", "BS"),
        Graduate("Criminal Just:Pol/Crts/Corr", "Rueda, Gabriella", "BS"),
        Graduate("Business Management", "Sawar, Muhammad Shah", "BS"),
        Graduate("Applied Psychology", "Sharma, Komal", "BS"),
        Graduate("Liberal Arts & Sciences", "Sharma, Komal", "AA"),
        Graduate("Computer Science", "Singh, Harpreet", "BS"),
        Graduate("Business Analytics", "Spinelli, Jason Michael", "BS"),
        Graduate("Liberal Arts & Sciences", "Syed, Nabiha", "AA"),
        Graduate("Science/Technology & Society", "Uhlmann, Haley Rose", "BS"),
        Graduate("Liberal Arts & Sciences", "Walpole, Marissa Marie", "AA"),
        Graduate("Business Management", "Williams, Daniel Christopher", "BS")
    )
}