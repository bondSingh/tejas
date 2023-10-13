package saty.learncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun previewListItem() {
    //listItem(image = R.drawable.spider_man, title = "Satish", subTitle = "Software Engineer")
    LazyColumn(content = {
        items(getHeroList()){item->
            listItem(image = item.image, title = item.title, subTitle = item.subTitle)
        }

    })
}

@Composable
fun listItem(image: Int, title: String, subTitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Android Image",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(0.2f)
            )
            extracted(title, subTitle, Modifier.weight(0.8f))
        }
    }

}

@Composable
fun extracted(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 22.sp,
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = subTitle,
            fontSize = 18.sp,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Thin
        )
    }
}

data class superHeros(val image: Int, val title: String, val subTitle: String)

fun getHeroList(): MutableList<superHeros> {
    val heroList = mutableListOf<superHeros>()
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man 2", "Webb Power"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.super_dad, "Super Dad", "Does Things"))
    heroList.add(superHeros(R.drawable.spider_man, "Spider Man", "Webb Power"))
    heroList.add(superHeros(R.drawable.red_man, "Super Man", "Fly Fast"))
    heroList.add(superHeros(R.drawable.captain_owl, "Captain Owl", "Shield"))
    return heroList

}