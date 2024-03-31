package natanel.android.tutorial2nav.components.bankingScreen.bottomNavBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastForEachIndexed

val items = listOf(
    BottomBankNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),

    BottomBankNavigation(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),

    BottomBankNavigation(
        title = "Notifications",
        icon = Icons.Rounded.Notifications
    ),

    BottomBankNavigation(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    ),
)

@Composable
fun BottomNavBar() {
    var itemClicked by remember {
        mutableIntStateOf(0)
    }
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.fastForEachIndexed { i, item ->
                NavigationBarItem( // need to explore how to use that
                    selected = i == itemClicked,
                    onClick = { itemClicked = i },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    })
            }
        }
    }
}