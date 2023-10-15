package saty.learncompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import saty.learncompose.models.Quote

object DataManager {
    var data = emptyArray<Quote>()

    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: Quote? = null
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data =
            gson.fromJson(json, saty.learncompose.models.Results::class.java).quotes.toTypedArray()
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}