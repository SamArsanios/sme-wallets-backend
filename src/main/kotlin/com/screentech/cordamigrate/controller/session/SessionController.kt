package com.screentech.cordamigrate.controller.session

import com.screentech.cordamigrate.dao.session.SessionRepository
import com.screentech.cordamigrate.entity.session.Session
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/smewallets/sessions")
class SessionController :  CRUDAbstract<Session>() {

    @Autowired
    lateinit var sessionRepository: SessionRepository

    @GetMapping("/create")
    override fun create(@RequestBody anObject: Session): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()
        return JSONUtilsKT.ok(this.sessionRepository.save(anObject))
    }

    @PutMapping("/update")
    override fun update(@RequestBody anObject: Session): ResponseEntity<*> {
        anObject.timestamp = parseStringToTimestamp(anObject.timestampStr)
        anObject.user.emailVerifiedAt = parseStringToTimestamp(anObject.user.emailVerifiedAtStr)
        return JSONUtilsKT.ok(this.sessionRepository.save(anObject))
    }

    @DeleteMapping("/delete")

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok(this.sessionRepository.findAll())
    }


    @GetMapping("/findSessionByUserId/{userId}")
    override fun findById(@PathVariable userId: Long): ResponseEntity<*> {
        return JSONUtilsKT.ok(this.sessionRepository.findByUserId(userId))
    }

}
