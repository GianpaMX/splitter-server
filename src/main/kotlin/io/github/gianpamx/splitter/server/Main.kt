package io.github.gianpamx.splitter.server

import io.github.gianpamx.splitter.server.app.AppModule

fun main(args: Array<String>) {
    DaggerMainComponent.builder()
        .appModule(AppModule())
        .build()
        .app()
        .start()
}
