package br.ufpe.cin.recl.apigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class ApigatewayApplication

fun main(args: Array<String>) {
	runApplication<ApigatewayApplication>(*args)
}
