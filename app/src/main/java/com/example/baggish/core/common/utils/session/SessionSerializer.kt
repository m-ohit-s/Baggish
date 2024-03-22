package com.example.baggish.core.common.utils.session

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream


object SessionSerializer: Serializer<Session> {
    override val defaultValue: Session
        get() = Session()

    override suspend fun readFrom(input: InputStream): Session {
        return try {
            Json.decodeFromString(
                deserializer = Session.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException){
            defaultValue
        }
    }

    override suspend fun writeTo(t: Session, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = Session.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}