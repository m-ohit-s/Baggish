package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.Constants
import com.example.baggish.feature.authentication.common.Resource
import com.example.baggish.feature.authentication.data.model.LoginUser
import com.example.baggish.feature.authentication.domain.model.LoginUserDomain
import com.example.baggish.feature.authentication.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class Login @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(user: LoginUserDomain): Flow<Resource<LoginUser>> {
        return flow {
            try {
                emit(Resource.Loading())
                val loggedInUser = loginRepository.login(user.email,user.password)
                emit(Resource.Success(loggedInUser))
            }
            catch (e: IOException){
                emit(Resource.Error(e.localizedMessage ?: Constants.NETWORK_ERROR))
            }
            catch (e: Exception){
                emit(Resource.Error(e.localizedMessage ?: Constants.UNEXPECTED_ERROR))
            }
        }
    }
}