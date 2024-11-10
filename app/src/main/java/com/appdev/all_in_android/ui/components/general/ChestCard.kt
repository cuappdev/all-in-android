package com.appdev.all_in_android.ui.components.general

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appdev.all_in_android.R
import com.appdev.all_in_android.ui.theme.CommonBlue
import com.appdev.all_in_android.ui.theme.EpicPurple
import com.appdev.all_in_android.ui.theme.LIGHT_GREY
import com.appdev.all_in_android.ui.theme.LegendaryYellow
import com.appdev.all_in_android.ui.theme.PlayerRed
import com.appdev.all_in_android.ui.theme.RareGreen

enum class CHEST_TYPE {
    PLAYER,
    RARITY
}

enum class CHEST_RARITY {
    COMMON {
        override fun name_string(): String {
            return "Common"
        }
        override fun color(): Color {
            return CommonBlue
        }

        override fun image_id(): Int {
            return R.drawable.common_chest
        }
    },
    RARE {
        override fun name_string(): String {
            return "Rare"
        }
        override fun color(): Color {
            return RareGreen
        }

        override fun image_id(): Int {
            return R.drawable.rare_chest
        }
    },
    EPIC {
        override fun name_string(): String {
            return "Epic"
        }
        override fun color(): Color {
            return EpicPurple
        }

        override fun image_id(): Int {
            return R.drawable.epic_chest
        }

    },
    LEGENDARY {
        override fun name_string(): String {
            return "Legendary"
        }
        override fun color(): Color {
            return LegendaryYellow
        }

        override fun image_id(): Int {
            return R.drawable.legendary_chest
        }
    };

    abstract fun color(): Color
    abstract fun image_id(): Int
    abstract fun name_string(): String
}

//TODO - the representation of a player/rarity may differ based on backend info
/**
 * Represents a chest card in the home page.
 * If the chestType is PLAYER, the player string and player_image_id must be set.
 * If the chestType is RARITY, the rarity field must be set.
 */
@Composable
fun ChestCard(
    chestType: CHEST_TYPE,
    player: String = "",
    player_image_id: Int = 0,
    rarity: CHEST_RARITY = CHEST_RARITY.COMMON,
    cost: Int
) {
    var headerText: String = ""
    var subText: String = ""
    var chest_image: Int = 0
    var textColor : Color = Color.Black
    if(chestType == CHEST_TYPE.RARITY) {
        headerText = rarity.name_string()
        subText = "Rarity Chest"
        chest_image = rarity.image_id()
        textColor = rarity.color()
    } else {
        headerText = player
        subText = "Player Chest"
        chest_image = R.drawable.player_chest
        textColor = PlayerRed
    }
    Box(modifier = Modifier.width(150.dp).height(205.dp), contentAlignment = Alignment.TopCenter) {
        Card(modifier = Modifier.padding(top=50.dp).fillMaxWidth().fillMaxHeight()) {
            Column(modifier = Modifier.padding(top=64.dp, bottom = 18.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(headerText, fontSize = 22.sp, lineHeight = 33.sp, fontWeight = FontWeight.Bold, color = textColor)
                Text(subText, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, lineHeight = 22.sp, color = LIGHT_GREY)
                Spacer(Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.cost_black), "", modifier = Modifier.size(width = 21.dp, height = 14.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("1,720", fontSize = 14.sp, fontWeight = FontWeight.Black, lineHeight = 14.sp, color = Color.Black)
                }
            }
        }

        Image(painter = painterResource(chest_image), contentDescription = "", modifier = Modifier.width(120.dp).height(105.dp).padding(top=12.dp))
        if(chestType == CHEST_TYPE.PLAYER) {

            Image(painter = painterResource(player_image_id), "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(top=12.dp, end = 13.dp)
                    .offset(x=45.dp)
                    .background(color = Color.White, shape = CircleShape)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(1.dp, Color.White),
                        CircleShape
                    ))



        }
        
    }
}

@Preview @Composable
fun chest_preview() {
    ChestCard(CHEST_TYPE.PLAYER, player = "Player Name", player_image_id = R.drawable.player_photo, cost = 1720)
}