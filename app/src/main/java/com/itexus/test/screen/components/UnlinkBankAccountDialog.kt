package com.itexus.test.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.itexus.test.R
import com.itexus.test.screen.BankAccountsScreenState

@Composable
internal fun UnlinkBankAccountDialog(
    removeAccountModel: BankAccountsScreenState.DialogType.Unlink,
    unlink: (String) -> Unit,
    cancel: () -> Unit
) {
    Dialog(
        onDismissRequest = {
            cancel()
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        UnlinkBankAccountDialogContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            account = removeAccountModel.account,
            unlink = { unlink(removeAccountModel.id) },
            cancel = cancel
        )
    }
}

@Composable
private fun UnlinkBankAccountDialogContent(
    modifier: Modifier = Modifier,
    account: String,
    unlink: () -> Unit,
    cancel: () -> Unit
) {

    val annotatedEmailSubTitle = buildAnnotatedString {
        append(stringResource(id = R.string.unlink_bank_account_subtitle_first_part) + " ")
        append("$account ")
        append(stringResource(id = R.string.unlink_bank_account_subtitle_second_part))
    }
    Box(
        modifier = Modifier
            .clickable { cancel() }
            .fillMaxSize()
    )

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(bottom = 16.dp, top = 24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth()
                    .weight(1f, false),
                text = stringResource(id = R.string.unlink_bank_account_title),
                textAlign = TextAlign.Start,
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = annotatedEmailSubTitle,
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(11.dp)
            ) {
                Button(
                    onClick = cancel,
                    modifier = Modifier
                        .testTag("")
                        .weight(1f)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(25f)
                        ),
                ) {
                    Text(
                        text = stringResource(id = R.string.unlink_bank_account_cancel),
                        color = Color.Black
                    )
                }
                Button(
                    onClick = unlink,
                    modifier = Modifier
                        .testTag("")
                        .weight(1f),
                ) {
                    Text(
                        text = stringResource(id = R.string.unlink_bank_account_unlink),
                        color = Color.Black
                    )
                }
            }
        }
    }
}