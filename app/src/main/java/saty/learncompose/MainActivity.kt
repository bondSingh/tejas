package saty.learncompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            previewListItem()
        }
    }
}

@Composable
fun sayHello(name: String) {
    Text(
        text = "Hello $name",
        color = Color.Blue,
        fontSize = 32.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.End
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, name = "boxOne", widthDp = 500, heightDp = 300)
@Composable
fun previewer() {
//sayHello(name = "manish")

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        buttonWithText()
        textInput()

        /*listItem(
            image = R.drawable.ic_launcher_foreground,
            name = "Satish",
            designation = "Software Engineer"
        )*/
    }
}

/*@Composable
fun listItem(image: Int, name: String, designation: String) {
    Row {
        image(image = image, 70.dp)
        Column {
            Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = designation, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }

}*/

@Composable
fun buttonWithText() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.Cyan
        ),
        enabled = false,
        border = BorderStroke(5.dp, Color.Red)
    ) {
        image(image = R.drawable.ic_launcher_foreground)
        sayHello(name = "Manish")
    }
}

@Composable
fun image(image: Int, size: Dp = 40.dp) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "Android Image",
        Modifier.size(size),
        colorFilter = ColorFilter.tint(Color.Magenta),
        contentScale = ContentScale.Crop,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textInput() {
    val state = remember { mutableStateOf("") }
    TextField(value = state.value, onValueChange = {
        state.value = it
        Log.d("satish", "it")
    })
}