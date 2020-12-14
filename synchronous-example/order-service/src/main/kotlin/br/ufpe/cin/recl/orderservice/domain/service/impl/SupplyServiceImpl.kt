package br.ufpe.cin.recl.orderservice.domain.service.impl

import br.ufpe.cin.recl.orderservice.domain.service.SupplyService
import br.ufpe.cin.recl.orderservice.rest.client.SupplyClient
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SupplyServiceImpl(
        private val supplyClient: SupplyClient
) : SupplyService {
    override fun reserve(productIds: List<Long>): BigDecimal {
        return supplyClient.reserveAll(productIds).sumOf { it }
    }
}