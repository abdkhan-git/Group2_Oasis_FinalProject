import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.group2_oasis_finalproject.UserViewModel
import androidx.compose.ui.Modifier


@Composable
fun ViewEmailScreen(navController: NavController, ramId: String) {
    // Correctly instantiate the ViewModel
    val userViewModel: UserViewModel = viewModel()

    // Load user data using the RAM ID
//    userViewModel.loadUserData(ramId)
//
//    // Access the userInfo, which could be null if not yet loaded
//    val user = userViewModel.userInfo

//    // Display loading state if user data is not available yet
//    if (user == null) {
//        Text(text = "Loading user data...", style = MaterialTheme.typography.bodyMedium)
//    } else {
//        // Display user information once available
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Text(text = "Email: ${user.Email}", style = MaterialTheme.typography.bodyMedium)
//            Text(text = "First Name: ${user.First}", style = MaterialTheme.typography.bodyMedium)
//            Text(text = "Last Name: ${user.Last}", style = MaterialTheme.typography.bodyLarge)
//            Text(text = "RAM ID: ${user.RamID}", style = MaterialTheme.typography.bodyLarge)
//        }
    }
//}
