package com.example.baggish.feature.landing_screen.presentation.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baggish.core.common.utils.session.Session
import com.example.baggish.core.common.utils.session.SessionCache
import com.example.baggish.feature.authentication.domain.use_case.Logout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sessionCache: SessionCache,
    private val logout: Logout
): ViewModel() {
    private var _session = MutableStateFlow(Session())
    val session: StateFlow<Session> = _session

    private var _sessionState = mutableStateOf(MainSessionState())
    val sessionState = _sessionState

    fun getActiveSession(){
        viewModelScope.launch {
            sessionCache.getActiveSession().collect{
                _session.value = it
            }
        }
    }
    fun clearSession(){
        viewModelScope.launch {
            sessionCache.clearSession()
        }
    }
    fun logout(){
        logout.invoke()
        _sessionState.value = _sessionState.value.copy(destroySession = true)
    }
}