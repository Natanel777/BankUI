package natanel.android.tutorial2nav.components.calculatorScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import natanel.android.tutorial2nav.components.calculatorScreen.usages.CalculatorAction
import natanel.android.tutorial2nav.components.calculatorScreen.usages.CalculatorButton
import natanel.android.tutorial2nav.components.calculatorScreen.usages.CalculatorOperation
import natanel.android.tutorial2nav.components.calculatorScreen.usages.CalculatorViewModel
import natanel.android.tutorial2nav.ui.theme.LightGray
import natanel.android.tutorial2nav.ui.theme.Orange


@Composable
fun Calculator() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    val buttonSpacing = 8.dp
    val onAction = viewModel ::onAction

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF1E1E1E))
        .padding(12.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter), // only because its inside the box i have the option
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2

            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "Ac",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalculatorAction.Clear)
                }

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Delete)
                }

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(7))
                }

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(8))
                }

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(9))
                }

                CalculatorButton(
                    symbol = "×",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(4))
                }

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(5))
                }

                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(6))
                }

                CalculatorButton(
                    symbol = "−",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(1))
                }

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(2))
                }

                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Number(3))
                }

                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CalculatorButton(
                    symbol = "0",
                    alignment = Alignment.CenterStart,
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f)
                        .padding(horizontal = 35.dp)
                ) {
                     onAction(CalculatorAction.Number(0))
                }

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                     onAction(CalculatorAction.Decimal)
                }

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Calculate)
                }

            }
        }

    }
}

@Composable
@Preview(showBackground = false, showSystemUi = true)
fun CalculatorPreview() {
    Calculator()
}
