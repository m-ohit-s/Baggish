package com.example.baggish.feature.authentication.data.di

import com.example.baggish.feature.authentication.data.repository.EmailValidationRepositoryImpl
import com.example.baggish.feature.authentication.data.repository.LoginRepositoryImpl
import com.example.baggish.feature.authentication.data.repository.PasswordValidationRepositoryImpl
import com.example.baggish.feature.authentication.data.repository.RegistrationRepositoryImpl
import com.example.baggish.feature.authentication.domain.repository.EmailValidationRepository
import com.example.baggish.feature.authentication.domain.repository.LoginRepository
import com.example.baggish.feature.authentication.domain.repository.PasswordValidationRepository
import com.example.baggish.feature.authentication.domain.repository.RegistrationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun provideEmailValidationRepository(): EmailValidationRepository{
        return EmailValidationRepositoryImpl
    }

    @Provides
    @Singleton
    fun providePasswordValidationRepository(): PasswordValidationRepository{
        return PasswordValidationRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideRegistrationRepository(): RegistrationRepository{
        return RegistrationRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideLoginRepository(): LoginRepository{
        return LoginRepositoryImpl()
    }
}