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
package com.kanyideveloper.muviz.cast.domain.repository

import com.kanyideveloper.muviz.cast.domain.model.Credits
import com.kanyideveloper.muviz.common.data.network.ASSUMED_MAX_TMDB_RATE_BYTES_PER_SECOND
import com.kanyideveloper.muviz.common.data.network.MAX_CONCURRENT_TMDB_REQUESTS
import com.kanyideveloper.muviz.common.util.Resource
import io.github.loinguyen.bandwidth.annotations.BandwidthDownload
import io.github.loinguyen.bandwidth.annotations.BandwidthEffect

interface CastRepository {
    @BandwidthEffect(
        downloads = [
            BandwidthDownload(
                rMaxBytesPerSecond = ASSUMED_MAX_TMDB_RATE_BYTES_PER_SECOND,
                nMax = 1,
                selfBound = MAX_CONCURRENT_TMDB_REQUESTS,
            ),
        ],
    )
    suspend fun getTvSeriesCasts(id: Int): Resource<Credits>

    @BandwidthEffect(
        downloads = [
            BandwidthDownload(
                rMaxBytesPerSecond = ASSUMED_MAX_TMDB_RATE_BYTES_PER_SECOND,
                nMax = 1,
                selfBound = MAX_CONCURRENT_TMDB_REQUESTS,
            ),
        ],
    )
    suspend fun getMovieCasts(id: Int): Resource<Credits>

    @BandwidthEffect(
        downloads = [
            BandwidthDownload(
                rMaxBytesPerSecond = ASSUMED_MAX_TMDB_RATE_BYTES_PER_SECOND,
                nMax = 1,
                selfBound = MAX_CONCURRENT_TMDB_REQUESTS,
            ),
        ],
    )
    suspend fun getCastDetails(id: Int): Resource<Unit>
}
