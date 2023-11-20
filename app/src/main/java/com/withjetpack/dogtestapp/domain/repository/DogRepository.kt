package com.withjetpack.dogtestapp.domain.repository

import com.withjetpack.dogtestapp.domain.Dog

interface DogRepository {
    suspend fun getDogs(): List<Dog>
}