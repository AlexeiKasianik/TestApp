package com.itexus.test.screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.itexus.test.R

@Composable
internal fun EmptyScreenDescription(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(
            start = 24.dp,
            top = 4.dp,
            end = 24.dp
        ),
        text = stringResource(id = R.string.empty_bank_accounts_list)
    )
}