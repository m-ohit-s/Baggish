package com.example.baggish.core.data.di

import android.content.Context
import com.example.baggish.core.common.utils.session.SessionCache
import com.example.baggish.core.common.utils.session.SessionCacheImpl
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
    fun provideSessionCache(@ApplicationContext context: Context): SessionCache{
        return SessionCacheImpl(context)
    }
}