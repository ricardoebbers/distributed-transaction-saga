package br.ufpe.cin.recl.orderservice.rest.client

import java.math.BigDecimal

interface PaymentConnector {
    fun executePayment(customerId: Long, totalPrice: BigDecimal): Long
}
