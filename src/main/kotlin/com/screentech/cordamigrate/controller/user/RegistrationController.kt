package com.screentech.cordamigrate.controller.user

import com.screentech.cordamigrate.dao.user.RegistrationRepository
import com.screentech.cordamigrate.entity.user.Registration
import com.screentech.cordamigrate.utility.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("api/smewallets/registrations")
class RegistrationController : CRUDAbstract<Registration>(){

    @Autowired
    lateinit var registrationRepository: RegistrationRepository

    @Autowired
    lateinit var notificationMessage: SimpMessagingTemplate

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Registration): ResponseEntity<*> {

        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)
        anObject.timestamp = getCurrentTimestampSQL()

        val result = JSONUtilsKT.ok(this.registrationRepository.save(anObject))

        this.notificationMessage.convertAndSend("/topic/registrations/create", result)

        return result
    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Registration): ResponseEntity<*> {

        anObject.user.emailVerifiedAt = parseStringToTimestamp(emailVerifiedAtStr())
        anObject.timestamp = parseStringToTimestamp(timestampStr())

        val result = JSONUtilsKT.ok(this.registrationRepository.save(anObject))

        this.notificationMessage.convertAndSend("/topic/registrations/update", result)

        return result
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.registrationRepository.findAll())

        this.notificationMessage.convertAndSend("/topic/registrations/findAll", result)

        return result
    }

    @GetMapping("findRegistrationByEmail/{email}")
    override fun findByEmail(@PathVariable email: String): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.registrationRepository.findRegistrationByEmail(email))

        this.notificationMessage.convertAndSend("/topic/registrations/findRegistrationByEmail", result)

        return result

    }

    @GetMapping("/findRegistrationById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.findById(id))

        this.notificationMessage.convertAndSend("/topic/registrations/findRegistrationById", result)

        return result

    }

}
