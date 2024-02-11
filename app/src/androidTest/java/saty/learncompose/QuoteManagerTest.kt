package saty.learncompose

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import saty.learncompose.models.Quote
import java.io.FileNotFoundException

class QuoteManagerTest {

    private lateinit var quoteManager:QuoteManager

    @Before
    fun setUp() {
        quoteManager = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("111","Satish", "Life is beautiful."),
            Quote("222","Manish", "Work is workship."),
            Quote("333","Pratibha", "All is well."),
            Quote("444","Shradha", "Believe in god."),
            Quote("555","Adi", "Kaani, paani")
        ))
    }

    @After
    fun tearDown() {
    }

    @Test(expected = FileNotFoundException::class)
    fun loadAssetFromFile() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.loadAssetFromFile("", context)
    }

    @Test(expected = JsonSyntaxException::class)
    fun loadAssetFromFile_Invalid_JSON() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.loadAssetFromFile("malformedquotes.json", context)
    }

    @Test()
    fun loadAssetFromFile_valid_JSON() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.loadAssetFromFile("quotes.json", context)
        assertEquals(20, quoteManager.quoteList.size)
    }

    @Test
    fun getCurrentQuote() {
        val quote = quoteManager.getCurrentQuote()
        assertEquals(quoteManager.quoteList[0], quote)
        assertNotEquals(quoteManager.quoteList[1], quote)
    }

    @Test
    fun getPreviousNextQuote() {
        val quote = quoteManager.getPreviousQuote()
        assertEquals(quoteManager.quoteList[0], quote)

        val quoteNext = quoteManager.getNextQuote()
        assertEquals(quoteManager.quoteList[1], quoteNext)

    }
}