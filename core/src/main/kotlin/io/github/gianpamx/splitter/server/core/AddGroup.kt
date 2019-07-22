package io.github.gianpamx.splitter.server.core

import io.github.gianpamx.splitter.server.core.entity.Group
import io.github.gianpamx.splitter.server.core.gateway.Persistence

class AddGroup(
    private val generateId: GenerateId,
    private val persistence: Persistence
) {
    operator fun invoke(owner: String) = generateId()
        .map { id -> Group(id, owner) }
        .flatMap { group -> persistence.createGroup(group) }
}
