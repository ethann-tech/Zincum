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

package io.github.uhsk.kit.android.defs

import android.media.AudioManager
import androidx.annotation.IntDef

@IntDef(value = [
    AudioManager.FLAG_SHOW_UI,
    AudioManager.FLAG_ALLOW_RINGER_MODES,
    AudioManager.FLAG_PLAY_SOUND,
    AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE,
    AudioManager.FLAG_VIBRATE,
])
@Retention(value = AnnotationRetention.SOURCE)
annotation class AudioServiceStreamFlags