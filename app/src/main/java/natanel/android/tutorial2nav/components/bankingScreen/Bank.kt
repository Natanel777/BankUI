package natanel.android.tutorial2nav.components.bankingScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import natanel.android.tutorial2nav.components.bankingScreen.bottomNavBar.BottomNavBar
import natanel.android.tutorial2nav.components.bankingScreen.cardSection.CardSection
import natanel.android.tutorial2nav.components.bankingScreen.currenciesSection.CurrenciesSection
import natanel.android.tutorial2nav.components.bankingScreen.financeSection.FinanceSection
import natanel.android.tutorial2nav.components.bankingScreen.walletSection.WalletSection

@Composable
fun Bank() {
    Scaffold(
        bottomBar = {
            BottomNavBar()
        }
        //padding make sure it content inside the Column is padded according topBar,bottomBar...
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            WalletSection()
            CardSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()
            CurrenciesSection()
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun BankPreview(){
    Bank()
}