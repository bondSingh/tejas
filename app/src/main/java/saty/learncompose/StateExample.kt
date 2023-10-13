package saty.learncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun NotificationScreen() {
    //State hoisting
    val count = rememberSaveable { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {

        NotificationCounter(count.value) { count.value++ }
        MessageBar(count.value) { count.value-- }

    }
}

//Unidirectional flow. Data flow from parent to childs, events fow in opposite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageBar(count: Int, decrement: () -> Unit) {
    Card(
        onClick = decrement,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

    ) {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "favourite",
                Modifier.padding(4.dp)
            )
            Text(text = "Total messages sent so far $count")
        }
    }
}

@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "You have sent $count notifications")
        Button(onClick = increment) {
            Text(text = "Send Notification")
        }
    }
}
