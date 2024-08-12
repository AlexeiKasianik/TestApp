package com.itexus.test.screen

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun LoadingState(
    isLoading: Boolean,
    content: @Composable (BoxScope) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(radius = 20.dp)
                        .clickable(enabled = false) { },
                    contentAlignment = Alignment.Center
                ) {
                    content(this)
                }
            } else {
                Box {
                    content(this)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color(0xFFFFFFFF).copy(alpha = 0.98f))
                    )
                }
            }
            CircularProgressIndicator(
                strokeCap = StrokeCap.Round,
                strokeWidth = 6.dp,
                modifier = Modifier.size(56.dp),
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) { })
        } else {
            content(this)
        }
    }
}