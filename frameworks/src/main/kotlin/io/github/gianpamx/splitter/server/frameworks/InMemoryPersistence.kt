package io.github.gianpamx.splitter.server.frameworks

import io.github.gianpamx.splitter.server.core.entity.Group
import io.github.gianpamx.splitter.server.core.gateway.Persistence
import io.reactivex.Single

class InMemoryPersistence : Persistence {
    private val groups = HashMap<String, Group>()

    override fun createGroup(group: Group) = Single.fromCallable {
        groups[group.id] = group
        return@fromCallable group
    }
}
