/*
 * Copyright 2026 Joel Kanyi.
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
package io.github.loinguyen.bandwidth.annotations

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class NetworkDownload(
    val maxBytes: Long,
    val completeTimeoutMillis: Long,
)

@Retention(AnnotationRetention.SOURCE)
annotation class BandwidthDownload(
    val rMaxBytesPerSecond: Long,
    val nMax: Int,
    val mayOutliveCall: Boolean = false,
    val selfBound: Int = 0,
)

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.TYPE,
)
@Retention(AnnotationRetention.SOURCE)
annotation class BandwidthEffect(
    val rMaxBytesPerSecond: Long = 0,
    val nMax: Int = 0,
    val downloads: Array<BandwidthDownload> = [],
)

@Target(
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER,
)
@Retention(AnnotationRetention.SOURCE)
annotation class BoundedClient(
    val k: Int,
)
