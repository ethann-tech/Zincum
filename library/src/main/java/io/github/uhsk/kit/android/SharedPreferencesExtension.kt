/*
 * Copyright (C) 2022. sollyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.uhsk.kit.android

import android.content.SharedPreferences
import org.json.JSONObject

/**
 * @since 1.0.3
 * @author sollyu
 */
fun SharedPreferences.has(key: String): Boolean = this.all.containsKey(key)

/**
 * @since 1.0.3
 * @author sollyu
 */
fun SharedPreferences.getJson(key: String, default: JSONObject? = null): JSONObject? {
    if (has(key).not()) {
        return default
    }
    val string: String = getString(key, null) ?: return default
    return JSONObject(string)
}

/**
 * @since 1.0.3
 * @author sollyu
 */
fun SharedPreferences.Editor.putJson(key: String, value: JSONObject): SharedPreferences.Editor {
    this.putString(key, value.toString())
    return this
}
