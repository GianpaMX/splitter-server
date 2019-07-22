package io.github.gianpamx.splitter.server.core

import io.reactivex.Single
import java.util.*

class GenerateId {
    operator fun invoke() = Single.just(UUID.randomUUID().toString())
}
