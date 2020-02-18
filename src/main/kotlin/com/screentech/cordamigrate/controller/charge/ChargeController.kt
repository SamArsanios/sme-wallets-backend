package com.screentech.cordamigrate.controller.charge

import com.screentech.cordamigrate.dao.charge.ChargeRepository
import com.screentech.cordamigrate.entity.charges.Charge
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/smewallets/charges")
class ChargeController : CRUDAbstract<Charge>() {

    @Autowired
    lateinit var chargeRepository: ChargeRepository

    @Autowired
    lateinit var notificationMessage: SimpMessagingTemplate

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Charge): ResponseEntity<*> {

        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)
        anObject.wallet.timestamp = parseStringToTimestamp(anObject.wallet.timestampStr)
        anObject.wallet.user?.emailVerifiedAt = parseStringToTimestamp(anObject.wallet.user?.emailVerifiedAtStr)

        val result = JSONUtilsKT.ok(this.chargeRepository.save(anObject))

        this.notificationMessage.convertAndSend("/topic/charges/create", result)

        return result

    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Charge): ResponseEntity<*>  {

        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)
        anObject.wallet.timestamp = parseStringToTimestamp(anObject.wallet.timestampStr)
        anObject.wallet.user?.emailVerifiedAt = parseStringToTimestamp(anObject.wallet.user?.emailVerifiedAtStr)

        val result = JSONUtilsKT.ok(this.chargeRepository.save(anObject))

        this.notificationMessage.convertAndSend("/topic/charges/update", result)

        return result

    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*>  {

        val result = JSONUtilsKT.ok(this.chargeRepository.findAll())

        this.notificationMessage.convertAndSend("/topic/charges/findAll", result)

        return result

    }

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.chargeRepository.findById(id))

        this.notificationMessage.convertAndSend("/topic/charges/findById", result)

        return result

    }

}
