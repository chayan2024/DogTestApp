package com.withjetpack.dogtestapp.di

import android.content.Context
import com.google.gson.Gson
import com.withjetpack.dogtestapp.data.DogRepositoryImpl
import com.withjetpack.dogtestapp.domain.repository.DogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideDogRepository(context: Context, gson: Gson): DogRepository {
        return DogRepositoryImpl(context, gson)
    }

}
