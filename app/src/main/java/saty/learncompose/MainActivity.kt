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
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import saty.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    private val quoteManager = QuoteManager
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //quoteManager = QuoteManager()
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            quoteManager.loadAssetFromFile("quotes.json", applicationContext)
        }
        setContent {
            App()
        }

    }

    @Preview
    @Composable
    private fun App() {
        var theme = remember { mutableStateOf(false) }
        LearnComposeTheme(theme.value) {
            if (quoteManager.isDataLoaded.value) {
                if (quoteManager.currentPage.value == Pages.LISTING) {
                    QuoteListScreen(data = quoteManager.quoteList,
                        dayNightThemeClick = {
                            Log.d("saty", "theme is :: ${theme.value}")
                            theme.value = !theme.value
                        }) {
                        Log.d("saty", "App()")
                        quoteManager.switchPages(it)
                    }
                } else {
                    quoteManager.currentQuoteItem?.let { QuoteDetail(quote = it) }
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

