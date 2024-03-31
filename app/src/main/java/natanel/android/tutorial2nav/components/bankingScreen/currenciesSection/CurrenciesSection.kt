package natanel.android.tutorial2nav.components.bankingScreen.currenciesSection

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyBitcoin
import androidx.compose.material.icons.rounded.CurrencyLira
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import natanel.android.tutorial2nav.ui.theme.GreenEnd
import java.text.NumberFormat
import java.util.Locale

var currenciesList = listOf(
    Currency(
        name = "USD",
        buy = 24.34f,
        sell = 24.28f,
        icon = Icons.Rounded.AttachMoney
    ),

    Currency(
        name = "EUR",
        buy = 28.45f,
        sell = 28.30f,
        icon = Icons.Rounded.Euro
    ),

    Currency(
        name = "YEN",
        buy = 0.221f,
        sell = 0.219f,
        icon = Icons.Rounded.CurrencyYen
    ),

    Currency(
        name = "TRY",
        buy = 0.220f,
        sell = 0.218f,
        icon = Icons.Rounded.CurrencyLira
    ),

    Currency(
        name = "BIT",
        buy = 70000.15f,
        sell = 70000.05f,
        icon = Icons.Rounded.CurrencyBitcoin
    ),
)

@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(true)
    }

    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        if (isVisible) {
                            iconState = Icons.Rounded.KeyboardArrowUp
                        } else {
                            iconState = Icons.Rounded.KeyboardArrowDown
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState,
                        contentDescription = iconState.name,
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
            )
            Spacer(modifier = Modifier.height(16.dp))

            //when closing we don't show it:
            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstraint = this
                    val width = boxWithConstraint.maxWidth / 3

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {

                        Spacer(modifier = Modifier.height(16.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                modifier = Modifier.width(width),
                                text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            Text(
                                modifier = Modifier.width(width),
                                text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.Center
                            )

                            Text(
                                modifier = Modifier.width(width),
                                text = "Sell",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn {
                            items(currenciesList.size) {
                                CurrencyItem(it, width)
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val currency = currenciesList[index]
    val formattedSellValue = NumberFormat.getNumberInstance(Locale.US).format(currency.sell)
    val formattedBuyValue = NumberFormat.getNumberInstance(Locale.US).format(currency.buy)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
            ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenEnd)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .width(width)
                    .padding(start = 10.dp),
                text = currency.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }



        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ $formattedBuyValue",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .width(width),
            text = "$ $formattedSellValue",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

    }
}