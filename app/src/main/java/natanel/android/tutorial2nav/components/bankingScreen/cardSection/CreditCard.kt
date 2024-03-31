package natanel.android.tutorial2nav.components.bankingScreen.cardSection

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter

data class CreditCard(
    val cardType:String,
    val cardNumber:String,
    val cardName:String,
    val balance:Double,
    val company: @Composable () -> Painter,
    val color: Brush
)

