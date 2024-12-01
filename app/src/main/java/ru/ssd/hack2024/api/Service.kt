package ru.ssd.hack2024.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ssd.hack2024.model.Transaction

object Service {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.104:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val mainService = retrofit.create(API::class.java)

    fun loadAllTransactions(): List<Transaction> {
        return mainService.transactions().execute().body()!!
    }
}