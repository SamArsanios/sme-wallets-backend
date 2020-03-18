package com.screentech.cordamigrate.controller.securityquestions

import com.screentech.cordamigrate.dao.securityquestion.SecurityQuestionRepository
import com.screentech.cordamigrate.entity.securityquestion.SecurityQuestion
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/smewallets/securityquestions")
class SecurityQuestionsController: CRUDAbstract<SecurityQuestion>() {

    @Autowired
    lateinit var securityQuestionsRepository: SecurityQuestionRepository

    @PostMapping("/create")
    override fun create(@RequestBody anObject: SecurityQuestion): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()

        val result = JSONUtilsKT.ok(this.securityQuestionsRepository.save(anObject))

        return result
    }

    @PutMapping("/update")
    fun UpdateSecurityQuestion(@RequestBody securityQuestion: SecurityQuestion):ResponseEntity<*>{
        securityQuestion.timestamp = parseStringToTimestamp(securityQuestion.timestampStr)

        val result = JSONUtilsKT.ok(this.securityQuestionsRepository.save(securityQuestion))

        return result
    }

    @DeleteMapping("/delete")
    fun deleteSecurityQuestion(@RequestBody securityQuestion: SecurityQuestion): ResponseEntity<*>{
        val result = JSONUtilsKT.ok(this.securityQuestionsRepository.delete(securityQuestion))
        return  result
    }

    @GetMapping("findAll")
    override fun findAll(): ResponseEntity<*> {
        return JSONUtilsKT.ok(securityQuestionsRepository.findAll())
    }

    @GetMapping("findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> {
        return JSONUtilsKT.ok(this.securityQuestionsRepository.findById(id))
    }
}

