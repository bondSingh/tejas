package saty.learncompose.models

import com.google.gson.annotations.SerializedName

data class Quote(
    val id: String,
    val author: String,
    val content: String,
)


data class Results(
    @SerializedName("results")
    val quotes: List<Quote>
)
