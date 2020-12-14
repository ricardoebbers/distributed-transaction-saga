package br.ufpe.cin.recl.orderservice.domain.service.impl

import br.ufpe.cin.recl.orderservice.domain.entity.OrderEntity
import br.ufpe.cin.recl.orderservice.domain.entity.OrderStatusEnum
import br.ufpe.cin.recl.orderservice.domain.repository.OrderRepository
import br.ufpe.cin.recl.orderservice.domain.service.OrderService
import br.ufpe.cin.recl.orderservice.domain.service.SupplyService
import br.ufpe.cin.recl.orderservice.rest.client.LogisticsConnector
import br.ufpe.cin.recl.orderservice.rest.client.PaymentConnector
import br.ufpe.cin.recl.orderservice.rest.command.OrderCommand
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class OrderServiceImpl(
        private val orderRepository: OrderRepository,
        private val supplyService: SupplyService,
        private val paymentConnector: PaymentConnector,
        private val logisticsConnector: LogisticsConnector
) : OrderService {
    override fun createOrder(orderCommand: OrderCommand): OrderEntity {
        val order: OrderEntity = orderRepository.saveAndFlush(orderCommand.toEntity())
        return try {
            val totalPrice: BigDecimal = supplyService.reserve(orderCommand.productIds)
            val paymentId = paymentConnector.executePayment(orderCommand.customerId, totalPrice)
            val shippingId = logisticsConnector.scheduleDelivery(orderCommand.address)
            orderRepository.saveAndFlush(order.copy(paymentId = paymentId, shippingId = shippingId, orderStatus = OrderStatusEnum.COMPLETED))
        } catch (ex: RuntimeException) {
            orderRepository.saveAndFlush(order.copy(orderStatus = OrderStatusEnum.REJECTED))
        }
    }
}