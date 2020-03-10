package com.screentech.cordamigrate.dao.ordernotifications

import com.screentech.cordamigrate.entity.ordernotifications.OrderNotifications
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
interface OrderNotificationsRepository: JpaRepository<OrderNotifications, Long> {
}