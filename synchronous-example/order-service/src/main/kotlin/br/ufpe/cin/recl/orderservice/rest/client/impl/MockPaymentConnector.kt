package br.ufpe.cin.recl.orderservice.rest.client.impl

import br.ufpe.cin.recl.orderservice.rest.client.PaymentConnector
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class MockPaymentConnector: PaymentConnector {
    private val log: Logger = LoggerFactory.getLogger(MockPaymentConnector::class.java)
    private var id = 0L

    override fun executePayment(customerId: Long, totalPrice: BigDecimal): Long {
        if(totalPrice >= BigDecimal(1000.0)) {
            Thread.sleep(1000)
            // mocks a silent fail from the underlying service
            log.warn("W=payment_silently_failed")
        } else {
            log.info("I=payment_successful")
        }
        id += 1L
        return id
    }
}