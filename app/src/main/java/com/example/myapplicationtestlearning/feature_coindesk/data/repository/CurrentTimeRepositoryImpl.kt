package com.example.myapplicationtestlearning.feature_coindesk.data.repository

import com.example.myapplicationtestlearning.feature_coindesk.data.local.CurrentTimeDao
import com.example.myapplicationtestlearning.feature_coindesk.data.remote.TimeApi
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.CurrentTime
import com.example.myapplicationtestlearning.feature_coindesk.domain.model.Time
import com.example.myapplicationtestlearning.feature_coindesk.domain.repository.CurrentTimeRepository
import com.example.myapplicationtestlearning.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CurrentTimeRepositoryImpl(
    private val api: TimeApi,
    private val dao: CurrentTimeDao
): CurrentTimeRepository {

    override fun getCurrentTime(): Flow<Resource<CurrentTime>> = flow {
        emit(Resource.Loading())

        val currentTime = if(dao.getCurrentTime() != null) dao.getCurrentTime().toCurrentTime() else CurrentTime("", "")
        emit(Resource.Loading(data = currentTime))

        try {
            val remoteCurrentTime = api.getCurrentTime()
            dao.deleteCurrentTime()
            dao.insertCurrentTime(remoteCurrentTime.toCurrentTimeEntity())
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = currentTime
            ))
        }catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = currentTime
                )
            )
        }
        val newCurrentTime = dao.getCurrentTime().toCurrentTime()
        emit(Resource.Success(newCurrentTime))
    }


}