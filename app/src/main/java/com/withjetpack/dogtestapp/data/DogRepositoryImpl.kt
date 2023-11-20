package com.withjetpack.dogtestapp.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.withjetpack.dogtestapp.domain.Dog
import com.withjetpack.dogtestapp.domain.repository.DogRepository

class DogRepositoryImpl (private val context: Context, private val gson: Gson):DogRepository{
    override suspend fun getDogs(): List<Dog> {
        val json = context.assets.open("Dogs.json").bufferedReader().use { it.readText() }
        return gson.fromJson(json, object : TypeToken<List<Dog>>() {}.type)
    }
}