package io.github.gianpamx.splitter.server.app

import dagger.Module
import dagger.Provides
import io.github.gianpamx.splitter.server.core.AddGroup
import io.github.gianpamx.splitter.server.groups.GroupsPresenter
import io.github.gianpamx.splitter.server.groups.GroupsRouter

@Module
class GroupsModule {
    @Provides
    fun provideGroupsPresenter(addGroup: AddGroup) = GroupsPresenter(addGroup)

    @Provides
    fun provideGroupsRouter(presenter: GroupsPresenter) =
        GroupsRouter(presenter)
}
