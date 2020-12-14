package br.ufpe.cin.recl.orderservice.domain.entity

import javax.persistence.*

@Entity
@Table(name = "orders")
data class OrderEntity(
        @Id
        @GeneratedValue
        var orderId: Long? = null,
        val customerId: Long,
        @ElementCollection
        val productIds: List<Long> = listOf(),
        val shippingId: Long? = null,
        val paymentId: Long? = null,
        val orderStatus: OrderStatusEnum = OrderStatusEnum.CREATED
)