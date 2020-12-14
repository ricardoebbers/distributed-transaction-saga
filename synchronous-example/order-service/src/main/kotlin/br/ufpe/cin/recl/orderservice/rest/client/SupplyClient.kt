package br.ufpe.cin.recl.orderservice.rest.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.math.BigDecimal

@FeignClient(name = "supply-service")
interface SupplyClient {
    @PostMapping("/reserve")
    fun reserveAll(@RequestBody productIds: List<Long>): List<BigDecimal>

}
