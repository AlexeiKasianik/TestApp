package com.itexus.test.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itexus.test.R
import com.itexus.test.screen.BankAccountsScreenState

@Composable
internal fun ScreenInfo(
    modifier: Modifier = Modifier,
    screenState: BankAccountsScreenState,
    unlinkAccountRequest: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {  }
            items(items = screenState.accounts, key = { it.id }) {
                SettingsMenuItem(
                    leadElement = R.drawable.bank_accounts_drawable,
                    menuItemLabel = it.title,
                    menuItemDescription = "**** " + it.subtitle,
                    onTrailingItemClick = { unlinkAccountRequest(it.id) },
                    modifier = Modifier
                )
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}