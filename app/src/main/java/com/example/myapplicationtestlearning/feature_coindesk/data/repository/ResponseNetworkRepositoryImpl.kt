package com.example.myapplicationtestlearning.feature_coindesk.data.repository

import com.example.myapplicationtestlearning.feature_coindesk.data.local.ResponseNetworkDao
import com.example.myapplicationtestlearning.feature_coindesk.data.remote.CoinDeskApi
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.ResponseNetwork
import com.example.myapplicationtestlearning.feature_coindesk.domain.repository.ResponseNetworkRepository
import com.example.myapplicationtestlearning.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ResponseNetworkRepositoryImpl(
    private val api: CoinDeskApi,
    private val dao: ResponseNetworkDao
): ResponseNetworkRepository {

    override fun getResponseNetwork(): Flow<Resource<ResponseNetwork>> = flow {
        emit(Resource.Loading())

        val responseNetwork = dao.getResponseNetwork().toResponseNetwork()
        emit(Resource.Loading(data = responseNetwork))

        try {
            val remoteResponseNetwork = api.getCurrentPrice()
            dao.deleteResponseNetwork()
            dao.insertResponseNetwork(remoteResponseNetwork.toResponseNetworkEntity())
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = responseNetwork
            ))
        }catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = responseNetwork
                )
            )
        }
        val newResposeNetwork = dao.getResponseNetwork().toResponseNetwork()
        emit(Resource.Success(newResposeNetwork))
    }


}