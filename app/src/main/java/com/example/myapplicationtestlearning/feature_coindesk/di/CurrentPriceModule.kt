package com.example.myapplicationtestlearning.feature_coindesk.di

import android.app.Application
import androidx.room.Room
import com.example.myapplicationtestlearning.feature_coindesk.data.local.Converters
import com.example.myapplicationtestlearning.feature_coindesk.data.local.ResponseNetworkDao
import com.example.myapplicationtestlearning.feature_coindesk.data.local.ResponseNetworkDatabase
import com.example.myapplicationtestlearning.feature_coindesk.data.remote.CoinDeskApi
import com.example.myapplicationtestlearning.feature_coindesk.data.repository.ResponseNetworkRepositoryImpl
import com.example.myapplicationtestlearning.feature_coindesk.data.utils.GsonParser
import com.example.myapplicationtestlearning.feature_coindesk.domain.repository.ResponseNetworkRepository
import com.example.myapplicationtestlearning.feature_coindesk.domain.use_case.GetCurrentPrice
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CurrentPriceModule {

    @Provides
    @Singleton
    fun provideGetCurrentPriceUseCase(repository: ResponseNetworkRepository): GetCurrentPrice {
        return GetCurrentPrice(repository)
    }

    @Provides
    @Singleton
    fun provideResponseNetworkRepository(
        db: ResponseNetworkDatabase,
        api: CoinDeskApi
    ): ResponseNetworkRepository {
        return ResponseNetworkRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideResponseNetworkDatabase(app: Application): ResponseNetworkDatabase {
        return Room.databaseBuilder(
            app, ResponseNetworkDatabase::class.java, "price_db"
        )
            .addTypeConverter(
                Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinDeskApi(): CoinDeskApi {
        return Retrofit.Builder()
            .baseUrl(CoinDeskApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinDeskApi::class.java)
    }


}