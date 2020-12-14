package br.ufpe.cin.recl.orderservice.rest.command

import br.ufpe.cin.recl.orderservice.rest.dto.AddressDTO
import br.ufpe.cin.recl.orderservice.domain.entity.OrderEntity

data class OrderCommand(
        val customerId: Long,
        val productIds: List<Long>,
        val address: AddressDTO
) {
    fun toEntity(): OrderEntity = OrderEntity(customerId = customerId, productIds = productIds)
}