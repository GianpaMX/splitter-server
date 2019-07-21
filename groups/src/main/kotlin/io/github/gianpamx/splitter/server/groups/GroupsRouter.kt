package io.github.gianpamx.splitter.server.groups

import io.github.gianpamx.splitter.server.features.FeatureResponse
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import kotlinx.coroutines.rx2.await

class GroupsRouter(private val presenter: GroupsPresenter) {
    fun route(route: Route) = with(route) {
        post("/") {
            presenter
                .addGroupRequest(call.receive())
                .map { FeatureResponse(message = it) }
                .onErrorReturn {
                    FeatureResponse(
                        HttpStatusCode.InternalServerError,
                        it.message ?: "Internal Server Error"
                    )
                }
                .await()
                .run {
                    call.respond(code, message)
                }
        }
    }
}
