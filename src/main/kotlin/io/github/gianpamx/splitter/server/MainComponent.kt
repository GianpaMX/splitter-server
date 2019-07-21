package io.github.gianpamx.splitter.server

import dagger.Component
import io.github.gianpamx.splitter.server.app.App
import io.github.gianpamx.splitter.server.app.AppModule
import io.github.gianpamx.splitter.server.app.CoreModule

@Component(
    modules = [
        AppModule::class,
        CoreModule::class
    ]
)
interface MainComponent {
    fun app(): App
}
