package br.ufpe.cin.recl.orderservice.domain.repository

import br.ufpe.cin.recl.orderservice.domain.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<OrderEntity, Long>
