package com.example.retrofitexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.retrofitexample.retrofit.ApiService
import com.example.retrofitexample.retrofit.RetrofitInstance
import com.example.retrofitexample.retrofit.model.Category
import com.example.retrofitexample.retrofit.util.Constants.Companion.NULLABLE_BODY_EXCEPTION
import com.example.retrofitexample.retrofit.util.Constants.Companion.TAG
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = RetrofitInstance.api
        lifecycleScope.launch {
            val fetchedList = testRetrofit(api)
            Log.d(TAG, fetchedList.random().strCategory)
        }
    }
}

private suspend fun testRetrofit(api: ApiService): List<Category> {
    val retrofitResponse = api.getAllCategories()
    if (!retrofitResponse.isSuccessful) {
        throw IllegalStateException("${retrofitResponse.code()}")
    }
    val fetchedList =
        retrofitResponse.body() ?: throw IllegalStateException(NULLABLE_BODY_EXCEPTION)
    return fetchedList.categories
}