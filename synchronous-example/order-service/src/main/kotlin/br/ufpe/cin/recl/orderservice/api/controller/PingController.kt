package br.ufpe.cin.recl.orderservice.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("ping")
class PingController {

    @GetMapping
    fun ping(): String {
        return "Pong!"
    }
}