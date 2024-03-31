package natanel.android.tutorial2nav.components.bankingScreen.financeSection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.Business
import androidx.compose.material.icons.rounded.Computer
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import natanel.android.tutorial2nav.ui.theme.BlueStart
import natanel.android.tutorial2nav.ui.theme.GreenStart
import natanel.android.tutorial2nav.ui.theme.OrangeStart
import natanel.android.tutorial2nav.ui.theme.PurpleStart

val financeList = listOf(
    Finance(
        icon = Icons.Rounded.Business,
        name = "Business",
        iconBackground = OrangeStart
    ),

    Finance(
        icon = Icons.Rounded.Wallet,
        name = "Wallet",
        iconBackground = BlueStart
    ),

    Finance(
        icon = Icons.AutoMirrored.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        iconBackground = PurpleStart
    ),

    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "Transactions",
        iconBackground = GreenStart
    ),
)
@Preview(showBackground = true)
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow{
            items(financeList.size){
                financeItem(it)
            }
        }
    }
}

@Composable
fun financeItem(index:Int) {
    val finance = financeList[index]
    var lastPaddingEnd = 0.dp

    if (index == financeList.size - 1){
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(100.dp)
                .clickable { }
                .padding(23.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(finance.iconBackground)
                .padding(6.dp)
            ){
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )

            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp

            )
        }

    }

}