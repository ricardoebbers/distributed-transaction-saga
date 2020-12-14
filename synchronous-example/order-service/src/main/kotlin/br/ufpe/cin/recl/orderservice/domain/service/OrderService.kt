package br.ufpe.cin.recl.orderservice.domain.service

import br.ufpe.cin.recl.orderservice.rest.command.OrderCommand
import br.ufpe.cin.recl.orderservice.domain.entity.OrderEntity

interface OrderService {
    fun createOrder(orderCommand: OrderCommand): OrderEntity
}
