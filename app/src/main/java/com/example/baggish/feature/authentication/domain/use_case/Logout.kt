package com.example.baggish.feature.authentication.domain.use_case

import android.util.Log
import com.example.baggish.core.common.utils.Constants
import com.example.baggish.core.common.utils.Resource
import com.example.baggish.feature.authentication.domain.repository.LogoutRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class Logout @Inject constructor(
    private val logoutRepository: LogoutRepository
){
    operator fun invoke(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                logoutRepository.logout()
            }
        }
        catch (e: Exception){
            Log.d("EXCEPTION", e.localizedMessage?: Constants.UNEXPECTED_ERROR)
        }
    }
}