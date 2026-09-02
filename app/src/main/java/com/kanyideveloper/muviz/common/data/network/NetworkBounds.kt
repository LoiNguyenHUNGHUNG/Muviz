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
package com.kanyideveloper.muviz.common.data.network

/** Assumed response-size bound used by the bandwidth case study. */
const val ASSUMED_MAX_TMDB_RESPONSE_BYTES = 5_000_000L

/** Ceiling of the assumed response bound divided by the complete-call deadline. */
const val ASSUMED_MAX_TMDB_RATE_BYTES_PER_SECOND = 333_334L

/** Complete-call deadline configured on the TMDB OkHttp client. */
const val TMDB_CALL_TIMEOUT_MILLIS = 15_000L

/** Maximum active requests admitted by the TMDB client dispatcher. */
const val MAX_CONCURRENT_TMDB_REQUESTS = 5

/** Maximum active requests admitted by the Coil client dispatcher. */
const val MAX_CONCURRENT_IMAGE_REQUESTS = 5
