package com.example.mvvmcleanhiltroom.data.cache.example.datasource

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.mvvmcleanhiltroom.data.cache.utils.AESUtils
import javax.inject.Inject

class SharedPrefLocalDataSource @Inject constructor(
    private val prefs: SharedPreferences
) {
    private var _exampleToken: String? = AESUtils.decrypt(prefs.getString(KEY_EXAMPLE_TOKEN, null))

    var exampleToken: String? = _exampleToken
        get() = AESUtils.decrypt(prefs.getString(KEY_EXAMPLE_TOKEN, null))
        set(value) {
            val encryptedExampleToken = AESUtils.encrypt(value)
            prefs.edit { putString(KEY_EXAMPLE_TOKEN, encryptedExampleToken) }
            field = value
        }

    companion object{
        private const val KEY_EXAMPLE_TOKEN = "example_token"
    }

}