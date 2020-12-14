package br.ufpe.cin.recl.orderservice.rest.api.controller

import br.ufpe.cin.recl.orderservice.rest.command.OrderCommand
import br.ufpe.cin.recl.orderservice.domain.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping
class OrderController(
        private val orderService: OrderService,
) {

    @PostMapping
    fun createOrder(@RequestBody orderCommand: OrderCommand): Long? {
        return orderService.createOrder(orderCommand).orderId
    }
}