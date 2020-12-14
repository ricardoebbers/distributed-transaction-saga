package br.ufpe.cin.recl.orderservice.domain.service

import java.math.BigDecimal

interface SupplyService {
    fun reserve(productIds: List<Long>): BigDecimal

}
