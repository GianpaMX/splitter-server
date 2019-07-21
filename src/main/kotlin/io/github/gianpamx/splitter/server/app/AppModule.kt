package io.github.gianpamx.splitter.server.app

import dagger.Module
import dagger.Provides
import io.github.gianpamx.splitter.server.groups.GroupsRouter

@Module(
    includes = [
        GroupsModule::class
    ]
)
class AppModule {
    @Provides
    fun provideApp(router: GroupsRouter) = App(8080, router)
}
