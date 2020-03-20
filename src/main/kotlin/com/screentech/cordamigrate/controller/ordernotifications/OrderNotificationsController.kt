package com.screentech.cordamigrate.controller.ordernotifications

import com.screentech.cordamigrate.dao.ordernotifications.OrderNotificationsRepository
import com.screentech.cordamigrate.entity.ordernotifications.OrderNotifications
import com.screentech.cordamigrate.entity.securityquestion.UserAnswer
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/smewallets/ordernotifications")
class OrderNotificationsController: CRUDAbstract<OrderNotifications>() {
    @Autowired
    lateinit var orderNotificationsRepository: OrderNotificationsRepository

    @PostMapping("/create")
    override fun create(anObject: OrderNotifications): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()
        val result = JSONUtilsKT.ok(orderNotificationsRepository.save(anObject))
        return result
    }

    @PutMapping("/update")
    fun updateOrderNotifications(@RequestBody orderNotifications: OrderNotifications):ResponseEntity<*>{
        orderNotifications.timestamp =  parseStringToTimestamp(orderNotifications.timestampStr)
        val result = JSONUtilsKT.ok(orderNotificationsRepository.save(orderNotifications))
        return result
    }

    @DeleteMapping("/delete")
    fun deleteOrderNotification(@RequestBody orderNotification: OrderNotifications) : ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.orderNotificationsRepository.delete(orderNotification))

//        this.notificationMessage.convertAndSend("/topic/users/delete", result)
        return result
    }

    @GetMapping("findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok(orderNotificationsRepository.findAll())
    }

    @GetMapping("findById/{Id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> {
        return JSONUtilsKT.ok(this.orderNotificationsRepository.findById(id))
    }

}