package saty.learncompose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import saty.learncompose.models.Quote
import saty.learncompose.ui.QuoteList
import saty.learncompose.ui.theme.montserratFontBold

@Composable
fun QuoteListScreen(
    data: Array<Quote>,
    dayNightThemeClick: () -> Unit,
    quoteItemClicked: (quote: Quote) -> Unit
) {
    Column {
        Row(modifier = Modifier.fillMaxWidth(1f)) {
            Text(
                text = "Quotes App",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp, 24.dp)
                    .weight(1f),
                style = MaterialTheme.typography.titleLarge,
                fontFamily = montserratFontBold
            )

            Image(
                imageVector = Icons.Filled.ModeNight,
                contentDescription = "Day Night Mode",
                modifier = Modifier
                    .clickable {
                        dayNightThemeClick()
                    }
                    .size(48.dp)
                    .align(alignment = Alignment.CenterVertically)


            )
        }
        QuoteList(quotes = data, quoteItemClicked)
    }

}