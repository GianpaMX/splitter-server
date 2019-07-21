package io.github.gianpamx.splitter.server.core

import io.github.gianpamx.splitter.server.core.entity.Group
import io.reactivex.Single

class AddGroup {
    operator fun invoke(owner: String) = Single.just(
        Group(
            "1",
            owner
        )
    )
}
