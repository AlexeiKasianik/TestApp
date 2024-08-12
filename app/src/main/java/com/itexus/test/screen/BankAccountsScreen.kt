package com.itexus.test.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itexus.test.R
import com.itexus.test.screen.components.AddButton
import com.itexus.test.screen.components.Title

@Composable
fun BankAccountsScreen(
    isLoading: Boolean,
    unlinkAccountRequest: (String) -> Unit,
    unlinkAccount: (String) -> Unit,
    dismissUnlinkAccount: () -> Unit,
    addAccount: () -> Unit,
) {


    Scaffold(
        topBar = {},
    ) { padding ->
        LoadingState(isLoading = isLoading) {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
            ) {
                Box(modifier = Modifier.fillMaxSize()) {

                    Column {
                        Title(
                            modifier = Modifier.padding(
                                top = 70.dp,
                                start = 16.dp,
                                end = 16.dp
                            )
                        )
                        Box(modifier = Modifier.weight(1f)) {

                        }
                        AddButton(
                            modifier = Modifier.padding(
                                bottom = 40.dp,
                                top = 24.dp,
                                start = 16.dp,
                                end = 16.dp
                            ),
                            onClick = addAccount
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomWindowWithTail() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .heightIn(min = 64.dp)
                .shadow(8.dp, RoundedCornerShape(10.dp))
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .border(
                    width = 0.5.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.add_bank_account_dialog_info)
            )
        }
        Box(
            modifier = Modifier
                .width(230.dp)
                .offset(x = (230 * 0.1).dp)
        ) {
            Canvas(
                modifier = Modifier
                    .width(16.dp)
                    .height(8.dp)
                    .offset(y = (-1).dp)
            ) {
                val trianglePath = Path().apply {
                    moveTo(size.width / 2, size.height)
                    lineTo(size.width, 0f)
                    lineTo(0f, 0f)
                    close()
                }
                drawPath(trianglePath, color = Color.White, style = Fill)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        CustomWindowWithTail()
    }
}


@Preview(name = "PIXEL_2_XL", device = Devices.PIXEL_2_XL)
@Preview(name = "PIXEL_3_XL", device = Devices.PIXEL_3_XL)
@Preview(name = "PIXEL_3A_XL", device = Devices.PIXEL_3A_XL)
@Preview(name = "PIXEL_4_XL", device = Devices.PIXEL_4_XL)
@Preview(name = "PIXEL_4_A", device = Devices.PIXEL_4A)
@Preview(name = "PIXEL_5", device = Devices.PIXEL_5)
@Preview(name = "PIXEL_6", device = Devices.PIXEL_6)
@Preview(name = "PIXEL_6A", device = Devices.PIXEL_6A)
@Preview(name = "PIXEL_6_PRO", device = Devices.PIXEL_6_PRO)
@Preview(name = "PIXEL_7", device = Devices.PIXEL_7)
@Preview(name = "PIXEL_7A", device = Devices.PIXEL_7A)
@Preview(name = "PIXEL_7_PRO", device = Devices.PIXEL_7_PRO)
@Composable
private fun EmptyBankAccountsScreenPreview() {
    BankAccountsScreen(
        isLoading = false,
        unlinkAccount = {},
        addAccount = {},
        unlinkAccountRequest = {},
        dismissUnlinkAccount = {},
    )
}
