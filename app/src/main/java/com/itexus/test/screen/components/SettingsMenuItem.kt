package com.itexus.test.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun SettingsMenuItem(
    modifier: Modifier = Modifier,
    leadElement: Int? = null,
    trailingElement: Int? = null,
    menuItemLabel: String,
    menuItemDescription: String,
    onTrailingItemClick: (() -> Unit)? = null,
    chip: String? = null,
    onItemClick: (() -> Unit)? = null,
    isSubtitleSingleLine: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable(enabled = onItemClick != null) { onItemClick?.let { it() } }
            .border(
                BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(12.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        leadElement?.let {
            Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(32.dp),
                painter = painterResource(id = it),
                contentDescription = "Lead icon"
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = 12.dp),
                text = menuItemLabel,
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    maxLines = if (isSubtitleSingleLine) {
                        1
                    } else {
                        Int.MAX_VALUE
                    },
                    overflow = if (isSubtitleSingleLine) {
                        TextOverflow.Ellipsis
                    } else {
                        TextOverflow.Clip
                    },
                    modifier = Modifier
                        .padding(bottom = 12.dp),
                    text = menuItemDescription,
                )
                chip?.let {
                    Text(
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(bottom = 12.dp, start = 12.dp)
                            .background(
                                color = Color.Black,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 2.dp),
                        text = chip.uppercase(),
                    )
                }
            }
        }

        val trailingModifier = if (onTrailingItemClick != null) Modifier
            .padding(end = 16.dp)
            .size(32.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable { onTrailingItemClick() } else Modifier
            .padding(end = 16.dp)
            .size(32.dp)

        trailingElement?.let {
            Image(
                modifier = trailingModifier,
                painter = painterResource(id = it),
                contentDescription = "Trailing item"
            )
        }
    }
}