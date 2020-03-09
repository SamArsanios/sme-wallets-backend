package com.screentech.cordamigrate.controller.securityquestions

import com.screentech.cordamigrate.dao.securityquestion.UserAnswerRepository
import com.screentech.cordamigrate.dao.user.UserRepository
import com.screentech.cordamigrate.entity.securityquestion.UserAnswer
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.CRUDAbstract
import com.screentech.cordamigrate.utility.JSONUtilsKT
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
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

        this.notificationMessage.convertAndSend("/topic/users/create", result)

        return result
    }
}