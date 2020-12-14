package br.ufpe.cin.recl.orderservice.rest.dto

data class AddressDTO(
        val zipCode: String,
        val street: String,
        val complement: String,
        val state: String,
        val city: String
)
