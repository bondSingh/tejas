package saty.learncompose.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import saty.learncompose.QuoteListItem
import saty.learncompose.models.Quote

@Composable
fun QuoteList(quotes: Array<Quote>, quoteItemClicked: (quote:Quote)-> Unit){

    LazyColumn(content = {
        items(quotes){
            QuoteListItem(quote = it, quoteItemClicked)
        }
    })

}