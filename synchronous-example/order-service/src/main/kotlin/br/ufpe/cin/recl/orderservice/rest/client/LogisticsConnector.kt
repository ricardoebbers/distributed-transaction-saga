package br.ufpe.cin.recl.orderservice.rest.client

import br.ufpe.cin.recl.orderservice.rest.dto.AddressDTO

interface LogisticsConnector {
    fun scheduleDelivery(address: AddressDTO): Long
}
