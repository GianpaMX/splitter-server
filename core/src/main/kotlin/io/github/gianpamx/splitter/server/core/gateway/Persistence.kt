package io.github.gianpamx.splitter.server.core.gateway

import io.github.gianpamx.splitter.server.core.entity.Group
import io.reactivex.Single

interface Persistence {
    fun createGroup(group: Group): Single<Group>
}
