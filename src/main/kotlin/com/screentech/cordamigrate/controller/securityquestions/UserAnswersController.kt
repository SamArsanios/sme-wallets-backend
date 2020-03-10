package com.screentech.cordamigrate.controller.securityquestions

import com.screentech.cordamigrate.dao.securityquestion.UserAnswerRepository
import com.screentech.cordamigrate.entity.securityquestion.UserAnswer
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import com.screentech.cordamigrate.utility.parseStringToTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController("/api/smewallets/useranswers")
class UserAnswersController: CRUDAbstract<UserAnswer>() {
    @Autowired
    lateinit var userAnswersRepository: UserAnswerRepository

    @Autowired
    lateinit var notificationMessage: SimpMessagingTemplate

    @PostMapping("/create")
    override fun create(@RequestBody anObject: UserAnswer): ResponseEntity<*> {
        anObject.timestamp = getCurrentTimestampSQL()

        val result = JSONUtilsKT.ok(this.userAnswersRepository.save(anObject))

//        this.notificationMessage.convertAndSend("/topic/users/create", result)

        return result
    }

    @PutMapping("/update")
    fun UpdateUserAnswer(@RequestBody userAnswer: UserAnswer) : ResponseEntity<*>{
        userAnswer.timestamp = parseStringToTimestamp(userAnswer.timestampStr)

        val result = JSONUtilsKT.ok(this.userAnswersRepository.save(userAnswer))

//        this.notificationMessage.convertAndSend("/topic/users/create", result)
        return result
    }

    @DeleteMapping("/delete")
    fun deleteUserAnswer(@RequestBody userAnswer: UserAnswer) : ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.userAnswersRepository.delete(userAnswer))

//        this.notificationMessage.convertAndSend("/topic/users/delete", result)

        return result
    }

    @GetMapping("/findAll")
    override fun findAll() : ResponseEntity<*> {

        //        this.notificationMessage.convertAndSend("/topic/users/findAll", result)
//Inline Variable
        return JSONUtilsKT.ok(userAnswersRepository.findAll())
    }

    @GetMapping("/findById/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<*> {

        val result = JSONUtilsKT.ok(this.userAnswersRepository.findById(id))

//        this.notificationMessage.convertAndSend("/topic/orders/findById", result)

        return result
    }
}