package saty.learncompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import saty.learncompose.models.Quote

class QuoteManager() {
    var quoteList = emptyArray<Quote>()

    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuoteItem: Quote? = null
    var currentQuoteIndex: Int = 0
    var isDataLoaded = mutableStateOf(false)


    fun loadAssetFromFile(file : String, context: Context) {
        val inputStream = context.assets.open(file)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList =
            gson.fromJson(json, saty.learncompose.models.Results::class.java).quotes.toTypedArray()
        isDataLoaded.value = true
    }
    fun populateQuotes(quoteArray: Array<Quote>){
        quoteList = quoteArray
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuoteItem = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }

    fun getCurrentQuote(): Quote? {
        return quoteList[currentQuoteIndex]
    }

    fun getNextQuote(): Quote {
        if (currentQuoteIndex == quoteList.size - 1) return quoteList[currentQuoteIndex]
        return quoteList[++currentQuoteIndex]
    }

    fun getPreviousQuote(): Quote {
        if (currentQuoteIndex == 0) return quoteList[currentQuoteIndex]
        return quoteList[--currentQuoteIndex]
    }
}