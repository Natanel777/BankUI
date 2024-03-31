package natanel.android.tutorial2nav.components.bankingScreen.cardSection

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import natanel.android.tutorial2nav.R
import natanel.android.tutorial2nav.ui.theme.BlueEnd
import natanel.android.tutorial2nav.ui.theme.BlueStart
import natanel.android.tutorial2nav.ui.theme.GreenEnd
import natanel.android.tutorial2nav.ui.theme.GreenStart
import natanel.android.tutorial2nav.ui.theme.MaxEndColor
import natanel.android.tutorial2nav.ui.theme.MaxStartColor
import natanel.android.tutorial2nav.ui.theme.OrangeEnd
import natanel.android.tutorial2nav.ui.theme.OrangeStart
import natanel.android.tutorial2nav.ui.theme.PurpleEnd
import natanel.android.tutorial2nav.ui.theme.PurpleStart

val cards = listOf(

    CreditCard(
        cardType = "VISA",
        cardNumber = "3444 2343 3434 1287",
        cardName = "Dream Card",
        balance = 1144.44,
        company = { getCompanyImage(id = R.drawable.max) },
        color = getGradient(MaxStartColor, MaxEndColor)
    ),

    CreditCard(
        cardType = "MASTER CARD",
        cardNumber = "2345 1538 3744 0755",
        cardName = "Business",
        balance = 15000.23,
        company = { getCompanyImage(id = R.drawable.cal) },
        color = getGradient(BlueStart, BlueEnd)
    ),

    CreditCard(
        cardType = "VISA",
        cardNumber = "0078 6754 2345 5463",
        cardName = "School",
        balance = 14.23,
        company = { getCompanyImage(id = R.drawable.isracartoldlogo) },
        color = getGradient(OrangeStart, OrangeEnd)
    ),

    CreditCard(
        cardType = "MASTER CARD",
        cardNumber = "6332 3453 1780 3454",
        cardName = "Trips",
        balance = 14.23,
        company = { getCompanyImage(id = R.drawable.isracartoldlogo) },
        color = getGradient(GreenStart, GreenEnd)
    ),

    CreditCard(
        cardType = "Visa",
        cardNumber = "8853 2533 2324 6586",
        cardName = "Casino",
        balance = 2000.0,
        company = { getCompanyImage(id = R.drawable.casino) },
        color = getGradient(PurpleStart, PurpleEnd)
    ),
)

@Composable
@Preview
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)

        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    /*
    Box is Flexible you dont have to define height or width inside it
    you can define it inside his BoxScope(Column) the desire props
    * */
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)

    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier.fillMaxWidth().padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = card.company(),
                    contentDescription = card.cardName,
                    modifier = Modifier.width(60.dp)
                )
                Text(
                    text = "${card.cardName} ",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )


            }


            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "₪ ${card.balance} ",
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_electronic),
                    contentDescription = card.cardName,
                    modifier = Modifier.width(20.dp)
                )
            }


            Text(
                text = card.cardNumber,
                color = Color.Black,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(50.dp)
                    .height(30.dp)
                    .align(Alignment.End)
            )

        }
    }
}

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun getCompanyImage(
    @DrawableRes id: Int
): Painter {
    return painterResource(id = id)
}