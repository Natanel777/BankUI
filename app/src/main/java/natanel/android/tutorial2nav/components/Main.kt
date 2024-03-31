package natanel.android.tutorial2nav.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import natanel.android.tutorial2nav.Screen

@Composable
fun Main(navController: NavController) {
    var text by remember {
        mutableStateOf("Nate")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()


    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceAround) {

            // --- Calculator

            Button(
                onClick = {
                    navController.navigate(Screen.CalculatorScreen.routh)
                    Log.d("nav Cal", Screen.CalculatorScreen.routh)

                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.hsl(0.69f,0.03f,0.60f)),
                modifier = Modifier
                    .background(color = Color(0xFFF59D50))
                    .drawBehind {
                        val gradient = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF2196F3),  // Blue
                                Color(0xFFD4D4D4), // Slightly darker gray
                                Color(0xFFA5A5A5), // Dark gray
                                Color(0xFFF59D50), // Orange
                                Color(0xFF607D8B), // Blue gray
                                Color(0xFF37474F), // Dark blue gray
                                Color(0xFF009688), // Teal
                                Color(0xFF689F38), // Green
                                Color(0xFFC2185B), // Pink
                                Color(0xFF2196F3)  // Blue

                            )
                        )
                        drawRect(

                            brush = gradient,
                            size = size,
                            style = Stroke(width = 4.dp.toPx()) // Adjust the width of the border as needed
                        )
                    }) {

                Text(text = "Calculator")
            }

            // --- DetailScreen

            Button(
                onClick = {
//                navController.navigate(Screen.DetailScreen.withArgs(text))
                    navController.navigate(Screen.DetailScreen.routh + "/$text")
                    Log.d("nav", Screen.DetailScreen.routh + "/$text")

                }
            ) {

                Text(text = "To DetailScreen")
            }

        }

        // --- Banking
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors  = ButtonDefaults.buttonColors(containerColor = Color.hsl(192f, 0.41f, 0.46f)),
            onClick = {
                navController.navigate(Screen.BankingScreen.routh)
            }) {
            Text(
                text = "To Banking App",
                fontFamily = FontFamily.Serif
            )
        }

    }
}