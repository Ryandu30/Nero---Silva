package com.example.nerosilva.di

import com.example.nerosilva.data.firebase.AuthRepository
import com.example.nerosilva.data.firebase.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/* Tambahkan Dependency Inject. Meskipun Tidak Dipanggil Tetapi Jika Dihapus
* akan Error Binding pada AuthRepository. Class Ini Digunakan untuk Inject Interface Karena Dibutuhkan */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}