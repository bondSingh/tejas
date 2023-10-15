package saty.learncompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import saty.learncompose.models.Quote

object DataManager {
    var data = emptyArray<Quote>()

    var isDataLoaded = mutableStateOf(false)

    fun loadAssetFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,saty.learncompose.models.Results::class.java).quotes.toTypedArray()
        isDataLoaded.value = true
    }
}