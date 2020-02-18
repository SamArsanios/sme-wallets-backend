package com.screentech.cordamigrate.controller.passwordreset

import com.screentech.cordamigrate.dao.passwordreset.PasswordResetRepository
import com.screentech.cordamigrate.entity.passwordreset.PasswordReset
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/smewallets/passwordresets")
class PasswordResetController : CRUDAbstract<PasswordReset>() {

    @Autowired
    lateinit var passwordResetRepository: PasswordResetRepository

    @PostMapping("/create")
    override fun create(anObject: PasswordReset): ResponseEntity<*> {
        anObject.createAt = getCurrentTimestampSQL()
        return JSONUtilsKT.ok(this.passwordResetRepository.save(anObject))
    }

    @PutMapping("/update")
    override fun update(anObject: PasswordReset): ResponseEntity<*> {
        anObject.createAt = parseStringToTimestamp(anObject.createAtStr)
        return JSONUtilsKT.ok(this.passwordResetRepository.save(anObject))
    }

    @GetMapping("/findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok(this.passwordResetRepository.findAll())
    }

    @GetMapping("findPasswordResetByEmail/{email}")
    override fun findByEmail(@PathVariable email: String): ResponseEntity<*> {
        return JSONUtilsKT.ok(this.passwordResetRepository.findByEmail(email))
    }

}
