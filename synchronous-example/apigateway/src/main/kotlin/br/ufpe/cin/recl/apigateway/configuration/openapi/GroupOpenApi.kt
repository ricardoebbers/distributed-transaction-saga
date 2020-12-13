package br.ufpe.cin.recl.apigateway.configuration.openapi

import org.springdoc.core.GroupedOpenApi
import org.springframework.cloud.gateway.route.RouteDefinitionLocator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GroupOpenApi(
        private val locator: RouteDefinitionLocator
) {
    @Bean
    fun apis(): List<GroupedOpenApi> {
        locator.routeDefinitions
                .collectList()
                .block()
                ?.filter { it.id.matches(".*-service".toRegex()) }
                ?.forEach {
                    val name = it.id.replace("-service".toRegex(), "")
                    GroupedOpenApi.builder().pathsToMatch("/$name/**").group(name).build()
                }
        return listOf()
    }
}