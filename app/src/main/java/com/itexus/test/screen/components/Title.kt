package com.itexus.test.screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.itexus.test.R

@Composable
internal fun Title(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(horizontal = 8.dp),
        text = stringResource(id = R.string.bank_accounts_screen_title),
    )
}