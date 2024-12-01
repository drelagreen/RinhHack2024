package ru.ssd.hack2024.api

import retrofit2.http.GET
import ru.ssd.hack2024.model.Transaction

interface API {
    @GET("/transactions")
    fun transactions() : retrofit2.Call<List<Transaction>>
}