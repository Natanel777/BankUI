package natanel.android.tutorial2nav.components.bankingScreen.currenciesSection

import androidx.compose.ui.graphics.vector.ImageVector

data class Currency(
    val name:String,
    val buy: Float,
    val sell:Float,
    val icon:ImageVector

)
