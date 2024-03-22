package com.example.baggish.core.common.utils.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

sealed class FirebaseUtils {
    class FirebaseAuthInstance{
        fun getFireBaseAuthInstance(): FirebaseAuth{
            return FirebaseAuth.getInstance()
        }

        private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

        companion object{
            private val instance = FirebaseAuthInstance()

            @JvmStatic
            fun getInstance(): FirebaseAuthInstance {
                return  instance
            }
        }
    }
    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun <T> Task<T>.await(): T{
        return suspendCancellableCoroutine {cont->
            addOnCompleteListener {
                if(it.exception != null){
                    cont.resumeWithException(it.exception!!)
                }
                else{
                    cont.resume(it.result, null)
                }
            }
        }
    }
}