package natanel.android.tutorial2nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import natanel.android.tutorial2nav.components.bankingScreen.Bank
import natanel.android.tutorial2nav.components.calculatorScreen.Calculator
import natanel.android.tutorial2nav.components.detailScreen.Detail
import natanel.android.tutorial2nav.components.Main


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.routh) {
        // --- Main Screen
        composable(route = Screen.MainScreen.routh) {
            MainScreen(navController = navController)
        }

        // --- Detail Screen
        composable(
            route = Screen.DetailScreen.routh + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Nate"
                    nullable = true
                }
            )

        ) { entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }

        // --- Calculator Screen
        composable(route = Screen.CalculatorScreen.routh){
            CalculatorScreen()
        }
        // ---  Banking Screen
        composable(route = Screen.BankingScreen.routh){
            BankingScreen()
        }
    }
}


@Composable
fun MainScreen(navController: NavController) {
    Main(navController = navController)
}

@Composable
fun DetailScreen(name: String?) {
    Detail(name = name)
}

@Composable
fun CalculatorScreen() {
    Calculator()
}

@Composable
fun BankingScreen() {
    Bank()
}



@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController)
}

