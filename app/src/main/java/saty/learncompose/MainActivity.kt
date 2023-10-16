package saty.learncompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import saty.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }

    @Composable
    private fun App() {
        var theme = remember { mutableStateOf(false) }
        LearnComposeTheme(theme.value) {
            if (DataManager.isDataLoaded.value) {
                if (DataManager.currentPage.value == Pages.LISTING) {
                    QuoteListScreen(data = DataManager.data,
                        dayNightThemeClick = {
                            Log.d("saty", "theme is :: ${theme.value}")
                            theme.value = !theme.value
                        }) {
                        Log.d("saty", "App()")
                        DataManager.switchPages(it)
                    }
                } else {
                    DataManager.currentQuote?.let { QuoteDetail(quote = it) }
                }

            } else {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize(1f)
                ) {
                    Text(text = "Loading...")
                }
            }
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}

