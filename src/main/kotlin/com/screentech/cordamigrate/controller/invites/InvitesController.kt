package com.screentech.cordamigrate.controller.invites

import com.screentech.cordamigrate.dao.invites.InvitesRepository
import com.screentech.cordamigrate.entity.invites.Invite
import com.screentech.cordamigrate.utility.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/smewallets/invites")
class InvitesController : CRUDAbstract<Invite>(){

    @Autowired
    lateinit var invitesRepository: InvitesRepository

    @Autowired
    lateinit var notificationMessage: SimpMessagingTemplate

    @PostMapping("/create")
    override fun create(@RequestBody anObject: Invite): ResponseEntity<*> {

        anObject.timestamp = getCurrentTimestampSQL()
        anObject.user.emailVerifiedAt = parseStringToTimestamp(timestampStr())

        val result = JSONUtilsKT.ok(this.invitesRepository.save(anObject))

        this.notificationMessage.convertAndSend("/topic/invites/create", result)

        return result

    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Invite): ResponseEntity<*> {

        anObject.timestamp = parseStringToTimestamp(anObject.timestampStr)
        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)

        val result = JSONUtilsKT.ok(this.invitesRepository.save(anObject))

        this.notificationMessage.convertAndSend("/topic/invites/update", result)

        return result
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.invitesRepository.findAll())

        this.notificationMessage.convertAndSend("/topic/invites/findAll", result)

        return result

    }

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> {

        val result =  JSONUtilsKT.ok(this.invitesRepository.findById(id))

        this.notificationMessage.convertAndSend("/topic/invites/findById", result)

        return result

    }

    @GetMapping("/findInvitesByEmail/{email}")
    override fun findByEmail(@PathVariable email: String): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.invitesRepository.findByEmail(email))

        this.notificationMessage.convertAndSend("/topic/invites/findInivitesByEmail", result)

        return result

    }
}
