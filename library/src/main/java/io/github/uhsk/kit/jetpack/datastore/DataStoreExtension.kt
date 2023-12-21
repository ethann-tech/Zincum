package io.github.uhsk.kit.jetpack.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

suspend fun DataStore<Preferences>.getInt(key: String): Int = this.data.map { it[intPreferencesKey(key)] ?: 0 }.first()

suspend fun DataStore<Preferences>.putInt(key: String, value: Int) = this.edit { it[intPreferencesKey(key)] = value }
suspend fun DataStore<Preferences>.getDouble(key: String):Double =this.data.map { it[doublePreferencesKey(key)] ?: .0 }.first()
suspend fun DataStore<Preferences>.putDouble(key: String, value: Double) =this.edit { it[doublePreferencesKey(key)] =value }
suspend fun DataStore<Preferences>.getFloat(key: String):Float = this.data.map { it[floatPreferencesKey(key)] ?: 0F }.first()
suspend fun DataStore<Preferences>.putFloat(key: String, value: Float)=this.edit { it[floatPreferencesKey(key)]=value }
suspend fun DataStore<Preferences>.getString(key: String): String = this.data.map { it[stringPreferencesKey(key)] ?: "" }.first()
suspend fun DataStore<Preferences>.putString(key: String, value: String) = this.edit { it[stringPreferencesKey(key)] = value }
suspend fun DataStore<Preferences>.getLong(key: String): Long = this.data.map { it[longPreferencesKey(key)] ?: 0L }.first()
suspend fun DataStore<Preferences>.putLong(key: String, value: Long) = this.edit { it[longPreferencesKey(key)] = value }
suspend fun DataStore<Preferences>.getBoolean(key: String):Boolean =this.data.map { it[booleanPreferencesKey(key)] ?: false}.first()
suspend fun DataStore<Preferences>.putBoolean(key: String, value:Boolean) =this.edit { it[booleanPreferencesKey(key)] =value }
suspend fun DataStore<Preferences>.getSetString(key: String):Set<String> =this.data.map { it[stringSetPreferencesKey(key)] ?: setOf("") }.first()
suspend fun DataStore<Preferences>.putSetString(key: String, value:Set<String>) =this.edit { it[stringSetPreferencesKey(key)] =value }

