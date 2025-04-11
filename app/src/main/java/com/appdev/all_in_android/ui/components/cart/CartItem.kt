package com.appdev.all_in_android.ui.components.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appdev.all_in_android.data.models.Contract
import com.appdev.all_in_android.data.models.ContractRepo

@Composable
fun CartItem(
    opponent: String,
    contractList: List<Contract>
){
    var checkedStatus by remember{mutableStateOf(false)}

    Column(
    ){
        Divider()
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(){
                Box(
                    modifier = Modifier.width(16.dp).height(16.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(12))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Cornell v. ${opponent}"
                )
            }


            Checkbox(
                modifier = Modifier.scale(0.75f),
                checked = checkedStatus,
                onCheckedChange = {checkedStatus = !checkedStatus}
            )
        }
    }
}

@Preview
@Composable
private fun CartItemPreview(){
    CartItem("UPenn", ContractRepo.players)
}