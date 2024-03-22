package com.example.baggish.core.common.utils.session

import android.content.Context
import androidx.datastore.dataStore
import com.example.baggish.core.common.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.datastore by dataStore(Constants.SESSION_FILE, SessionSerializer)

class SessionCacheImpl(private val context: Context): SessionCache {
    override suspend fun saveSession(session: Session) {
        context.datastore.updateData {
            it.copy(
                session.user,
                session.token
            )
        }
    }

    override suspend fun getActiveSession(): Flow<Session> = context.datastore.data.map {

        Session(
            user = it.user,
            token = it.token
        )
    }

    override suspend fun clearSession() {
        context.datastore.updateData {
            it.copy(SessionUser(), "")
        }
    }

}