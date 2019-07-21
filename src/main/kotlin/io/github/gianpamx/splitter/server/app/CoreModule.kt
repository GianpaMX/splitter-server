package io.github.gianpamx.splitter.server.app

import dagger.Module
import dagger.Provides
import io.github.gianpamx.splitter.server.core.AddGroup

@Module
class CoreModule {
    @Provides
    fun provideAddGroup() = AddGroup()
}
