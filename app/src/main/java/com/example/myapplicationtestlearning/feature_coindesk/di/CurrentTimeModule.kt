package com.example.myapplicationtestlearning.feature_coindesk.di

import android.app.Application
import androidx.room.Room
import com.example.myapplicationtestlearning.feature_coindesk.data.local.CurrentTimeDatabase
import com.example.myapplicationtestlearning.feature_coindesk.data.remote.TimeApi
import com.example.myapplicationtestlearning.feature_coindesk.data.repository.CurrentTimeRepositoryImpl
import com.example.myapplicationtestlearning.feature_coindesk.domain.repository.CurrentTimeRepository
import com.example.myapplicationtestlearning.feature_coindesk.domain.use_case.GetCurrentTime
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CurrentTimeModule {

    @Provides
    @Singleton
    fun provideGetCurrentTimeUseCase(repository: CurrentTimeRepository): GetCurrentTime {
        return GetCurrentTime(repository)
    }

    @Provides
    @Singleton
    fun provideCurrentTimeRepository(
        db: CurrentTimeDatabase,
        api: TimeApi
    ): CurrentTimeRepository {
        return CurrentTimeRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideCurrentTimeDatabase(app: Application): CurrentTimeDatabase {
        return Room.databaseBuilder(
            app, CurrentTimeDatabase::class.java, "time_db"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideTimeApi(): TimeApi {
        return Retrofit.Builder()
            .baseUrl(TimeApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TimeApi::class.java)
    }


}