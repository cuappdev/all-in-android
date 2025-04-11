package com.appdev.all_in_android.ui.components.cart

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appdev.all_in_android.R

@Composable
fun Checkbox(
    isChecked: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isChecked) Color(0xFF99C5F4) else Color(0xff1F70C7),
        label = "background"
    )

    Box(
        modifier = Modifier
            .size(18.dp)
            .padding(2.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(12))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = isChecked) {
            Icon(
                painter = painterResource(R.drawable.ic_checkmark),
                contentDescription = "Checkmark",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview
@Composable
private fun CheckboxPreview(){
    Column{
        Checkbox(true, {})
        Checkbox(false, {})
    }
}
