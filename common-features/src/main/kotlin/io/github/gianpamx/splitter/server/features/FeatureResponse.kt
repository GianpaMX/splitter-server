package io.github.gianpamx.splitter.server.features

import io.ktor.http.HttpStatusCode

data class FeatureResponse(
    val code: HttpStatusCode = HttpStatusCode.OK,
    val message: Any
)
