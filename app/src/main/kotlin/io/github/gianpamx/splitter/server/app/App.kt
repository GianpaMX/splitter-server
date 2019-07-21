package io.github.gianpamx.splitter.server.app

import io.github.gianpamx.splitter.server.groups.GroupsRouter
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.routing.Routing
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

class App(port: Int, router: GroupsRouter) {
    val server: ApplicationEngine

    init {
        server = embeddedServer(Netty, port = port) {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }

            routing {
                route("/groups", router)
            }
        }
    }

    fun start() {
        server.start(wait = true)
    }

    private fun Routing.route(path: String, router: GroupsRouter) {
        route(path) {
            router.route(this)
        }
    }
}
