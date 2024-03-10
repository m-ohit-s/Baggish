package com.example.baggish.feature.authentication.domain.use_case

import com.example.baggish.feature.authentication.common.Constants
import com.example.baggish.feature.authentication.common.Resource
import com.example.baggish.feature.authentication.data.model.RegisterUser
import com.example.baggish.feature.authentication.domain.model.User
import com.example.baggish.feature.authentication.domain.repository.RegistrationRepository
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class Registration @Inject constructor(
    private val registrationRepository: RegistrationRepository
) {
    operator fun invoke(user: User): Flow<Resource<RegisterUser>> {
        return flow{
            try {
                emit(Resource.Loading())
                val name = user.firstName + " " + user.lastName
                val registeredUser = registrationRepository.register(name, user.email, user.password)
                emit(Resource.Success(registeredUser))
            }
            catch (e: FirebaseAuthException){
                emit(Resource.Error(e.localizedMessage?: Constants.UNEXPECTED_ERROR))
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