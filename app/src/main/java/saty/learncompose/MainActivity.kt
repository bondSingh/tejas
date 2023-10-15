package saty.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }

    @Composable
    private fun App() {
        if (DataManager.isDataLoaded.value){
            QuoteListScreen(data = DataManager.data) {
            }
        } else{
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(1f)){
                Text(text = "Loading...")
            }
        }
    }
}


