package io.github.gianpamx.splitter.server.groups

import io.github.gianpamx.splitter.server.core.AddGroup

class GroupsPresenter(private val addGroup: AddGroup) {
    fun addGroupRequest(input: GroupInput) = addGroup(input.owner).map { mapOf("id" to it.id) }
}
