/*
 * Copyright 2024 Joel Kanyi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kanyideveloper.muviz

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.kanyideveloper.muviz.common.di.ImageLoadingClient
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MuvizApp : Application(), ImageLoaderFactory {
    @Inject
    @ImageLoadingClient
    lateinit var imageLoadingClient: OkHttpClient

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    override fun newImageLoader(): ImageLoader = ImageLoader.Builder(this)
        .okHttpClient(imageLoadingClient)
        .build()

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
