package natanel.android.tutorial2nav.components.calculatorScreen.usages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    alignment: Alignment = Alignment.Center,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = alignment,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
    ){
        Text(
            text = symbol,
            fontSize = 36.sp,
            color = Color.White
        )
    }
}
@Preview(showBackground = true)
@Composable
fun CalculatorButtonPreview() {
    CalculatorButton("+", Modifier.background(color = Color(0xFFF59D50))) {}
}