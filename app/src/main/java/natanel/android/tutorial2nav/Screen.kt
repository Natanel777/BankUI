package natanel.android.tutorial2nav

sealed class Screen(val routh: String) {
     data object MainScreen: Screen("main_screen")
     data object DetailScreen: Screen("detail_screen")
     data object CalculatorScreen: Screen("cal_screen")
     data object BankingScreen: Screen("banking_screen")

     fun withArgs(vararg args: String) : String{
          return buildString {
               append(routh)
               args.forEach { arg ->
                    append("/$arg")
               }
          }
     }
}