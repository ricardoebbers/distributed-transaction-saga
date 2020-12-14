package br.ufpe.cin.recl.orderservice.rest.client.impl

import br.ufpe.cin.recl.orderservice.rest.dto.AddressDTO
import br.ufpe.cin.recl.orderservice.rest.client.LogisticsConnector
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class MockLogisticsConnector : LogisticsConnector {
    private val log: Logger = LoggerFactory.getLogger(MockPaymentConnector::class.java)
    private var id = 0L

    override fun scheduleDelivery(address: AddressDTO): Long {
        if (address.zipCode.startsWith("51020")) {
            log.warn("W=delivery_throws_error")
            throw RuntimeException("LogisticsConnector failed with no fallback available.")
        } else {
            log.info("I=delivery_successful")
            id += 1L
            return id
        }

    }
}